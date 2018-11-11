package com.evilgeniuses.condorlabs;

public class TeamModel {

    private String name;            // Team name
    private String description;     // Team description
    private String year;            // Foundation Year

    public TeamModel(String name, String description, String year) {
        this.name = name;
        this.description = description;
        this.year = year;
    }

    public TeamModel() {}

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
