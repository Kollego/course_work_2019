package com.vaadin.backend;

import java.util.ArrayList;

public class PossibleRisk {
    private String name;
    private String description;
    private int type;
    public ArrayList<Integer> criteria;
    private boolean used;

    public PossibleRisk(String name, String description)
    {
        this.name = name;
        this.description = description;
        criteria = new ArrayList<>();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Integer> getCriteria() {
        return criteria;
    }

    public void addCriteria(int k){criteria.add(k);}

    public void setCriteria(ArrayList<Integer> criteria) {
        this.criteria = criteria;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
