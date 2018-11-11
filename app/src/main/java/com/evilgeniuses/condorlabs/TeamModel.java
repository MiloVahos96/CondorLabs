package com.evilgeniuses.condorlabs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamModel {

    private String strTeam;         // Team name
    private String strStadium;      // Team stadium
    private String strTeamBadge;    // Team Badge URL
    private String idTeam;          // Id del equipo

    public TeamModel() {}

    public TeamModel(String strTeam, String strStadium, String strTeamBadge, String idTeam) {
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strTeamBadge = strTeamBadge;
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }
}
