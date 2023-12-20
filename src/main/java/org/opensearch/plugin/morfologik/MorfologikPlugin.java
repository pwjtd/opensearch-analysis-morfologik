/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
package org.opensearch.plugin.morfologik;

import org.apache.lucene.analysis.Analyzer;
import org.opensearch.index.analysis.AnalyzerProvider;
import org.opensearch.index.analysis.TokenFilterFactory;
import org.opensearch.indices.analysis.AnalysisModule;
import org.opensearch.plugins.AnalysisPlugin;
import org.opensearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;


public class MorfologikPlugin extends Plugin implements AnalysisPlugin {

    public static final String ANALYZER_NAME = "morfologik";

    public static final String FILTER_NAME = "morfologik_stem";

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap(ANALYZER_NAME, (indexSettings, environment, name, settings) -> new MorfologikAnalyzerProvider(indexSettings, name, settings));
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return Collections.singletonMap(FILTER_NAME, MorfologikTokenFilterFactory::new);
    }
}
