package com.easyecom.googlecalenderevent.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class AddEvent {

    private String eventName;
    private String eventDescription;
    private int duration;

    //@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date StartTime;

    private String email;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddEvent(String eventName, String eventDescription, int duration, Date startTime, String email) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.duration = duration;
        StartTime = startTime;
        this.email = email;
    }

    public AddEvent() {
    }

}
