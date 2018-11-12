package com.evilgeniuses.condorlabs;

public class EventModel {

    private String strEvent;
    private String dateEvent;

    public EventModel() {}

    public EventModel(String strEvent, String dateEvent) {
        this.strEvent = strEvent;
        this.dateEvent = dateEvent;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

}
