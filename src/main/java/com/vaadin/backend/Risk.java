package com.vaadin.backend;


public class Risk {
    private int id;
    private String name = "";
    private String description = "";
    private Double probability;
    private Double impact;
    private Double level;
    private String isCritical = "";
    private String responsible = "";
    private String category = "";


    public Risk(int id, String name, String description, double probability, double impact) {
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

    public Risk(String name, String description) {
        this.name = name;
        this.description = description;
        id = DataProviderHelper.getRiskCount() + 1;
    }

    public Risk(String name, String description, String responsible, String category) {
        this.name = name;
        this.description = description;
        this.responsible = responsible;
        this.category = category;
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

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Double getImpact() {
        return impact;
    }

    public void setImpact(Double impact) {
        this.impact = impact;
    }

    public Double getLevel() {
        if(impact != null && probability != null)
            return impact*probability;
        else
            return 0d;
    }

    public void setLevel(Double level) {this.level = level;}

    public String getisCritical() { return isCritical; }

    public void setisCritical(String critical) { isCritical = critical; }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
