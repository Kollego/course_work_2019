package com.vaadin.backend;

public class PossibleRisk {
    private String name;
    private String description;
    private int type;
    private int criteria;

    public PossibleRisk(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCriteria() {
        return criteria;
    }

    public void setCriteria(int criteria) {
        this.criteria = criteria;
    }
}
