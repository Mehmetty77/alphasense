package com.ali.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeywordSearchPojo {

    private List<Topics> topics;
    private SearchResults searchResults;

    public KeywordSearchPojo() {
    }

    public KeywordSearchPojo(List<Topics> topics, SearchResults searchResults) {
        this.topics = topics;
        this.searchResults = searchResults;
    }

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    @Override
    public String toString() {
        return "AdditionalKeywordSearchResult{" +
                "topics=" + topics +
                ", searchResults=" + searchResults +
                '}';
    }
}
