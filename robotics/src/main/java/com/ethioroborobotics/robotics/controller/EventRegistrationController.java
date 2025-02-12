package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.EventRegistration;
import com.ethioroborobotics.robotics.repository.EventRegistrationRepository;
import com.ethioroborobotics.robotics.service.EventRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EventRegistration> createEventRegistration(String email, @RequestBody EventRegistration eventRegistration){
        if (eventRegistrationRepository.findByEmail(email).isPresent()){
            throw new  RuntimeException("The user is already exist!");
        }
        EventRegistration saved=eventRegistrationService.createRegistration(eventRegistration);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<EventRegistration>> getAllEventRegistrations(){
        return ResponseEntity.ok(eventRegistrationService.getAllRegistrations());
    }

    @GetMapping("/attendee/{email}")
    public ResponseEntity<Optional<EventRegistration>> getEventRegistrationByEmail(@PathVariable("email") String email){
        return ResponseEntity.status(HttpStatus.OK).body(eventRegistrationService.getRegistrationByEmail(email));
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<Optional<EventRegistration>> updateEventRegistration(@PathVariable("email") String email,@RequestBody EventRegistration eventRegistration){
        Optional<EventRegistration> saved=eventRegistrationService.updateRegistration(email,eventRegistration);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(saved) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEventRegistration(@PathVariable("id") Integer registrationId){
        eventRegistrationService.deleteEventRegistration(registrationId);
        return ResponseEntity.ok("EventRegistration cancelled successfully!");
    }
}
