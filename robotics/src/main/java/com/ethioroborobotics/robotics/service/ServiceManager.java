package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Services;
import com.ethioroborobotics.robotics.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ServiceManager {

    private final ServiceRepository serviceRepository;

    public Services addService(Services service){
        return serviceRepository.save(service);
    }

    public List<Services> getAllServices(){
        return serviceRepository.findAll();
    }

    public Optional<Services> getService(Integer id){
        return serviceRepository.findById(id);
    }

    public Optional<Services> updateService(Integer id, Services service){
        return serviceRepository.findById(id).map(update->{

            update.setCategory(service.getCategory());
            update.setDescription(service.getDescription());
            update.setLocation(service.getLocation());
            update.setContactInfo(service.getContactInfo());
            update.setTargetAudience(service.getTargetAudience());

            return serviceRepository.save(update);
        });
    }

    public void deleteService(Integer id){
        serviceRepository.deleteById(id);
    }



}
