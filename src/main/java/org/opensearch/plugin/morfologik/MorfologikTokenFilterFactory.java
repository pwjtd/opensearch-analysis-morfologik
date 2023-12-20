/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
package org.opensearch.plugin.morfologik;

import morfologik.stemming.Dictionary;
import morfologik.stemming.polish.PolishStemmer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.morfologik.MorfologikFilter;
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
import java.io.IOException;

/**
 * Tokenizer factory.
 */
public class MorfologikTokenFilterFactory extends AbstractTokenFilterFactory {

    /**
     * Dictionary parameter name.
     */
    public static final String DICTIONARY_PARAM = "dictionary";

    private final Dictionary dictionary;

    /**
     * Creates tokenizer.
     * @param indexSettings index settings
     * @param env environment
     * @param name name
     * @param settings settings
     * @throws IOException initialize exception
     */
    public MorfologikTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) throws IOException {
        super(indexSettings, name, settings);
        dictionary = getDictionary(env, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new MorfologikFilter(tokenStream, dictionary);
    }

    private Dictionary getDictionary(Environment env, Settings settings) throws IOException {
        String dictionaryParam = settings.get(DICTIONARY_PARAM);
        if (dictionaryParam == null) {
            return new PolishStemmer().getDictionary();

        }
        return Dictionary.read(env.configFile().resolve(dictionaryParam));
    }
}