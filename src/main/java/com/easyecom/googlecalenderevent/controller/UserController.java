package com.easyecom.googlecalenderevent.controller;

import com.easyecom.googlecalenderevent.model.AddEvent;
import com.easyecom.googlecalenderevent.model.Events;
import com.easyecom.googlecalenderevent.model.User;
import com.easyecom.googlecalenderevent.repository.EventsRepository;
import com.easyecom.googlecalenderevent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EventsRepository eventsRepo;

    @Autowired
    private UserRepository userRepo;

    //to add new event
    @PostMapping("addnewevent")
    public Events postEvent(@RequestBody AddEvent addEvents){
        Optional<User> user = userRepo.findByEmailForEvent(addEvents.getEmail());
        if (user.isPresent()){
            User userName =user.get();
            Events userEvents = new Events(addEvents.getEventName(), addEvents.getEventDescription(), addEvents.getDuration(), addEvents.getStartTime(), userName);
            Events saveEvents = eventsRepo.save(userEvents);
            return saveEvents;
        }
    return null;
//        Events userEvents =new Events();
//        Events saveEvents = eventsRepo.save(userEvents);
//        return saveEvents;

    }

//    @GetMapping("getallevents")
//    public List<Events> getEvents()
//    {
//        List<Events> events = (List<Events>) eventsRepo.findAll();
//
//        return events;
//    }

    //get all projects of loggedin user by user email
    @GetMapping("viewParticularUserEvents")
    public List<Events> getEventsByUserEmail(@RequestParam("email") String email)
    {
        Date currentTime = new Date();
        Optional<User> user = userRepo.findByEmailForEvent(email);
        if (user.isPresent()) {
            List<Events> events = eventsRepo.findByUserEmail(email,currentTime);
            return events;
        }else
            return null;
    }


}
