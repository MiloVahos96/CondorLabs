package com.evilgeniuses.condorlabs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamListModel {

    @SerializedName("teams")
    private List<TeamModel> teams;

    public TeamListModel() {
    }

    public TeamListModel(List<TeamModel> teams) {
        this.teams = teams;
    }

    public List<TeamModel> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamModel> teams) {
        this.teams = teams;
    }
}
