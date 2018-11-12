package com.evilgeniuses.condorlabs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamModel {

    private String strTeam;         // Team name
    private String strStadium;      // Team stadium
    private String strTeamBadge;    // Team Badge URL
    private String strTeamJersey;   // Team Jersey URL
    private String idTeam;          // Id del equipo
    private String intFormedYear;   // Año de formación
    private String strDescriptionEN;// Descripción en Inglés
    private String strWebsite;      // URL website
    private String strFacebook;     // URL Facebook
    private String strInstagram;    // URL Instagram

    public TeamModel() {}

    public TeamModel(String strTeam, String strStadium, String strTeamBadge, String strTeamJersey, String idTeam, String intFormedYear, String strDescriptionEN, String strWebsite, String strFacebook, String strInstagram) {
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strTeamBadge = strTeamBadge;
        this.strTeamJersey = strTeamJersey;
        this.idTeam = idTeam;
        this.intFormedYear = intFormedYear;
        this.strDescriptionEN = strDescriptionEN;
        this.strWebsite = strWebsite;
        this.strFacebook = strFacebook;
        this.strInstagram = strInstagram;
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

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }
}
