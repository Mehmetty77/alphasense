package com.ali.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statements {

    private String accessionNumber;
    private List<CollapsedStatements> collapsedStatements;
    private String content;
    private boolean context;
    private int page;
    private boolean recurring;
    private int snippetCount;
    private int snippetOffset;
    private String statementId;
    private int statementIndex;
    private int statementIndexOffset;

    public Statements() {
    }

    public Statements(String accessionNumber, List<CollapsedStatements> collapsedStatements, String content, boolean context, int page, boolean recurring, int snippetCount, int snippetOffset, String statementId, int statementIndex, int statementIndexOffset) {
        this.accessionNumber = accessionNumber;
        this.collapsedStatements = collapsedStatements;
        this.content = content;
        this.context = context;
        this.page = page;
        this.recurring = recurring;
        this.snippetCount = snippetCount;
        this.snippetOffset = snippetOffset;
        this.statementId = statementId;
        this.statementIndex = statementIndex;
        this.statementIndexOffset = statementIndexOffset;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public List<CollapsedStatements> getCollapsedStatements() {
        return collapsedStatements;
    }

    public void setCollapsedStatements(List<CollapsedStatements> collapsedStatements) {
        this.collapsedStatements = collapsedStatements;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isContext() {
        return context;
    }

    public void setContext(boolean context) {
        this.context = context;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public int getSnippetCount() {
        return snippetCount;
    }

    public void setSnippetCount(int snippetCount) {
        this.snippetCount = snippetCount;
    }

    public int getSnippetOffset() {
        return snippetOffset;
    }

    public void setSnippetOffset(int snippetOffset) {
        this.snippetOffset = snippetOffset;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public int getStatementIndex() {
        return statementIndex;
    }

    public void setStatementIndex(int statementIndex) {
        this.statementIndex = statementIndex;
    }

    public int getStatementIndexOffset() {
        return statementIndexOffset;
    }

    public void setStatementIndexOffset(int statementIndexOffset) {
        this.statementIndexOffset = statementIndexOffset;
    }

    @Override
    public String toString() {
        return "Statements{" +
                "accessionNumber='" + accessionNumber + '\'' +
                ", collapsedStatements=" + collapsedStatements +
                ", content='" + content + '\'' +
                ", context=" + context +
                ", page=" + page +
                ", recurring=" + recurring +
                ", snippetCount=" + snippetCount +
                ", snippetOffset=" + snippetOffset +
                ", statementId='" + statementId + '\'' +
                ", statementIndex=" + statementIndex +
                ", statementIndexOffset=" + statementIndexOffset +
                '}';
    }
}
