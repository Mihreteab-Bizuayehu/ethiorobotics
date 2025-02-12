package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Event;
import com.ethioroborobotics.robotics.repository.EventRepository;
import com.ethioroborobotics.robotics.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Event> createEvent(Integer eventId, @RequestBody Event event){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.addEvent(event));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEvents());
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Optional<Event>> getEventById(@PathVariable("id") Integer eventId){
        return ResponseEntity.status(HttpStatus.OK).body(eventService.getEventById(eventId));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Optional<Event>> updateEvent(@PathVariable("id") Integer eventId,@RequestBody Event event){
        if (eventRepository.findById(eventId).isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventService.updateEvent(eventId,event));
        }
        throw new RuntimeException("Event is not found!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Integer eventId){

        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }

}