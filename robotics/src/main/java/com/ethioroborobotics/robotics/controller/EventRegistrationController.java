package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.EventRegistration;
import com.ethioroborobotics.robotics.repository.EventRegistrationRepository;
import com.ethioroborobotics.robotics.service.EventRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/event-registrations")
public class EventRegistrationController {

    private final EventRegistrationService eventRegistrationService;
    private final EventRegistrationRepository eventRegistrationRepository;

    @PostMapping("/add")
    public EventRegistration createEventRegistration(String email, @RequestBody EventRegistration eventRegistration){
        if (eventRegistrationRepository.findByEmail(email).isPresent()){
            throw new  RuntimeException("The user is already exist!");
        }
        return eventRegistrationService.createRegistration(eventRegistration);
    }

    @GetMapping
    public List<EventRegistration> getAllEventRegistrations(){
        return eventRegistrationService.getAllRegistrations();
    }

    @GetMapping("/attendee/{email}")
    public Optional<EventRegistration> getEventRegistrationByEmail(@PathVariable("email") String email){
        return eventRegistrationService.getRegistrationByEmail(email);
    }

    @PutMapping("/update/{email}")
    public Optional<EventRegistration> updateEventRegistration(@PathVariable("email") String email,@RequestBody EventRegistration eventRegistration){
        return eventRegistrationService.updateRegistration(email,eventRegistration);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEventRegistration(@PathVariable("id") Integer registrationId){
        eventRegistrationService.deleteEventRegistration(registrationId);
    }
}
