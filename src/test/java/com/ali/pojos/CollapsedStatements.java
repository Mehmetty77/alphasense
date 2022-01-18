package com.ali.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollapsedStatements {
    private String collapsedstatement;

    public CollapsedStatements() {
    }

    public CollapsedStatements(String collapsedstatement) {
        this.collapsedstatement = collapsedstatement;
    }

    public String getCollapsedstatement() {
        return collapsedstatement;
    }

    public void setCollapsedstatement(String collapsedstatement) {
        this.collapsedstatement = collapsedstatement;
    }

    @Override
    public String toString() {
        return "CollapsedStatements{" +
                "collapsedstatement='" + collapsedstatement + '\'' +
                '}';
    }
}
