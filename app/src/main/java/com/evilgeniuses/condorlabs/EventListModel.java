package com.evilgeniuses.condorlabs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventListModel {

    @SerializedName("events")
    private List<EventModel> events;

    public EventListModel() {}

    public EventListModel(List<EventModel> events) {
        this.events = events;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }
}
