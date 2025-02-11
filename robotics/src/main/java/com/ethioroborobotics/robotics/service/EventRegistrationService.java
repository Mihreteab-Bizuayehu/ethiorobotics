package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.EventRegistration;
import com.ethioroborobotics.robotics.repository.EventRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventRegistrationService {

    private  final EventRegistrationRepository eventRegistrationRepository;

    public EventRegistration createRegistration(EventRegistration eventRegistration){
        return eventRegistrationRepository.save(eventRegistration);
    }

    public List<EventRegistration> getAllRegistrations(){
        return eventRegistrationRepository.findAll();
    }

    public Optional<EventRegistration> getRegistrationByEmail(String email){
        return eventRegistrationRepository.findByEmail(email);
    }

    public Optional<EventRegistration> updateRegistration(String email,EventRegistration eventRegistration){
        return eventRegistrationRepository.findByEmail(email).map(update->{
            update.setAttendeeName(eventRegistration.getAttendeeName());
            update.setEvent(eventRegistration.getEvent());
            update.setEmail(eventRegistration.getEmail());
            update.setPhone(eventRegistration.getPhone());

            return eventRegistrationRepository.save(update);
        });
    }

    public void deleteEventRegistration(Integer registrationId){
        eventRegistrationRepository.deleteById(registrationId);
    }
}
