# Morfologik Polish Lemmatizer plugin for OpenSearch
Simple OpenSearch analysis plugin for Polish language. It's base on lucene-analysis-morfologik which is java library
implementation of [Morfologik](http://morfologik.blogspot.com).

Helpful links:
https://github.com/allegro/elasticsearch-analysis-morfologik

## Dependecies

## Install

### OpenSearch
```
opensearch-plugin install https://github.com/Ksawierek/opensearch-analysis-morfologik/releases/download/2.11.1/opensearch-analysis-morfologik-2.11.1.zip
```

### Containerfile
```
FROM opensearchproject/opensearch:2.11.1

RUN opensearch-plugin install https://github.com/Ksawierek/opensearch-analysis-morfologik/releases/download/2.11.1/opensearch-analysis-morfologik-2.11.1.zip
```
