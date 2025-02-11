package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Event;
import com.ethioroborobotics.robotics.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Integer eventId) {
        return eventRepository.findById(eventId);
    }

    public Optional<Event> updateEvent(Integer eventId, Event event) {
        return eventRepository.findById(eventId).map(updatedEvent->{
            updatedEvent.setEventName(event.getEventName());
            updatedEvent.setLocation(event.getLocation());
            updatedEvent.setDescription(event.getDescription());
            updatedEvent.setEventTime(event.getEventTime());
            updatedEvent.setEventDate(event.getEventDate());
            updatedEvent.setStatus(event.getStatus());
            return eventRepository.save(updatedEvent);
        });
    }

    public void deleteEvent(Integer eventId){
        eventRepository.deleteById(eventId);
    }
}
