package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.CompetitionRegistration;
import com.ethioroborobotics.robotics.repository.CompetitionRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompetitionRegistrationService {

    private  final CompetitionRegistrationRepository competitionRegistrationRepository;

    public CompetitionRegistration addRegistration(CompetitionRegistration competitionRegistration){
        return competitionRegistrationRepository.save(competitionRegistration);
    }

    public List<CompetitionRegistration> getAllRegistrations(){
        return competitionRegistrationRepository.findAll();
    }

    public Optional<CompetitionRegistration> getRegistration(Integer id){
        return competitionRegistrationRepository.findById(id);
    }

    public Optional<CompetitionRegistration> updateRegistration(Integer id,CompetitionRegistration competition){
        return competitionRegistrationRepository.findById(id).map(update->{

            update.setCompetitionName(competition.getCompetitionName());
            update.setLocation(competition.getLocation());
            update.setPricingDetails(competition.getPricingDetails());
            update.setRegistrationLink(competition.getRegistrationLink());
            update.setNotes(competition.getNotes());
            update.setRegistrationDate(competition.getRegistrationDate());
            update.setDueDate(competition.getDueDate());

            return competitionRegistrationRepository.save(update);
        });
    }

    public void deleteCompetition(Integer id){
        competitionRegistrationRepository.deleteById(id);
    }

}
