package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Event;
import com.ethioroborobotics.robotics.repository.EventRepository;
import com.ethioroborobotics.robotics.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("events")
public class EventController {

    private final EventService eventService;
    private final EventRepository eventRepository;

    @PostMapping("/add")
    public Event createEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("/event/{id}")
    public Optional<Event> getEventById(@PathVariable("id") Integer eventId){
        return eventService.getEventById(eventId);
    }

    @PutMapping("update/{id}")
    public Optional<Event> updateEvent(@PathVariable("id") Integer eventId,@RequestBody Event event){
        if (eventRepository.findById(eventId).isPresent()){
            return eventService.updateEvent(eventId,event);
        }
        throw new RuntimeException("Event is not found!");
    }

    public void deleteEvent(Integer eventId){
        eventService.deleteEvent(eventId);
    }

}