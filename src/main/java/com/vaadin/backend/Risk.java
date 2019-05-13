package com.vaadin.backend;


public class Risk {
    private int id;
    private String name;
    private String description;
    private Integer probability;
    private Integer impact;
    private Integer level;


    public Risk(int id, String name, String description, int probability, int impact) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.probability = probability;
        this.impact = impact;
    }

    public Risk(String name) {
        this.name = name;
        id = DataProviderHelper.getRiskCount() + 1;
    }

    public Risk() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public Integer getImpact() {
        return impact;
    }

    public void setImpact(Integer impact) {
        this.impact = impact;
    }

    public Integer getLevel() {
        if(impact != null && probability != null)
            return impact*probability;
        else
            return 0;
    }

    public void setLevel(Integer level) {this.level = level;}

}
