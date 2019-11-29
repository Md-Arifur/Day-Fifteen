package com.bitm.addshowevent.model;

public class Event {
    private String eventId;
    private String eventName;
    private String eventLocation;
    private String startDate;
    private String endDate;
    private double budget;

    public Event() {
    }

    public Event(String eventName, String eventLocation, String startDate, String endDate, double budget) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Event(String eventId, String eventName, String eventLocation, String startDate, String endDate, double budget) {
        this(eventName,eventLocation,startDate,endDate,budget);
        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getBudget() {
        return budget;
    }
}
