package com.easyecom.googlecalenderevent.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String eventName;
    private String eventDescription;
    private int duration;
    private Date startTime;

    @ManyToOne
    @JoinColumn(name="email", nullable=false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Events(Long id, String eventName, String eventDescription, int duration, Date startTime, User user) {
        this.id = id;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.duration = duration;
        this.startTime = startTime;
        this.user = user;
    }

    public Events(String eventName, String eventDescription, int duration, Date startTime, User user) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.duration = duration;
        this.startTime = startTime;
        this.user = user;
    }

    public Events() {
    }

}
