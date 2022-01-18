package com.ali.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResults {
    private String cursorToken;
    private int originalStatementCount;
    private List<Statements> statements;

    public SearchResults() {
    }

    public SearchResults(String cursorToken, int originalStatementCount, List<Statements> statements) {
        this.cursorToken = cursorToken;
        this.originalStatementCount = originalStatementCount;
        this.statements = statements;
    }

    public String getCursorToken() {
        return cursorToken;
    }

    public void setCursorToken(String cursorToken) {
        this.cursorToken = cursorToken;
    }

    public int getOriginalStatementCount() {
        return originalStatementCount;
    }

    public void setOriginalStatementCount(int originalStatementCount) {
        this.originalStatementCount = originalStatementCount;
    }

    public List<Statements> getStatements() {
        return statements;
    }

    public void setStatements(List<Statements> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "cursorToken='" + cursorToken + '\'' +
                ", originalStatementCount=" + originalStatementCount +
                ", statements=" + statements +
                '}';
    }
}
