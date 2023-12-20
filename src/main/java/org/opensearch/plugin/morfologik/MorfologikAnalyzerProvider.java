/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
package org.opensearch.plugin.morfologik;

import org.apache.lucene.analysis.morfologik.MorfologikAnalyzer;
import org.opensearch.common.settings.Settings;
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;

/**
 * Creates MorfologikAnalyzer.
 */
public class MorfologikAnalyzerProvider extends AbstractIndexAnalyzerProvider<MorfologikAnalyzer> {

    private final MorfologikAnalyzer analyzer;

    /**
     * Creates provider.
     * @param indexSettings index settings
     * @param name analyzer name
     * @param settings settings
     */
    public MorfologikAnalyzerProvider(IndexSettings indexSettings, String name, Settings settings) {
        super(indexSettings, name, settings);
        analyzer = new MorfologikAnalyzer();
    }

    /**
     * Gets morfologik analyzer.
     */
    @Override
    public MorfologikAnalyzer get() {
        return analyzer;
    }
}