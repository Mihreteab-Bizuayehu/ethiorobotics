package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Application;
import com.ethioroborobotics.robotics.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<Application> getApplicationsByName(String name) {
        return applicationRepository.getApplicationByName(name);
    }

    public Optional<Application> updateApplication(Long applicationId, Application updatedApplication) {
        return applicationRepository.findById(applicationId).map(application -> {
            application.setName(updatedApplication.getName());
            application.setEmail(updatedApplication.getEmail());
            application.setPhone(updatedApplication.getPhone());
            application.setApplicationDate(updatedApplication.getApplicationDate());
            application.setAvailability(updatedApplication.getAvailability());
            application.setMessage(updatedApplication.getMessage());
            application.setSkills(updatedApplication.getSkills());
            application.setRoleInterest(updatedApplication.getRoleInterest());
            return applicationRepository.save(application);
        });
    }

    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }


}
