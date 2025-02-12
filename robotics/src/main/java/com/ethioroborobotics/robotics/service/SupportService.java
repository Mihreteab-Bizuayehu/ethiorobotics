package com.ethioroborobotics.robotics.service;


import com.ethioroborobotics.robotics.entity.Support;
import com.ethioroborobotics.robotics.repository.SupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupportService {

    private final SupportRepository supportRepository;

    public Support addSupport(Support support){
        return supportRepository.save(support);
    }

    public List<Support> getAllSupports(){
        return supportRepository.findAll();
    }

    public Optional<Support> getSupportById(Integer supportId){
        return supportRepository.findById(supportId);
    }

    public Optional<Support> updateSupport(Integer supportId,Support support){
        return supportRepository.findById(supportId).map(update->{

            update.setSupportType(support.getSupportType());
            update.setAvailability(support.getAvailability());
            update.setDescription(support.getDescription());
            update.setContactMethod(support.getContactMethod());
            update.setContactDetails(support.getContactDetails());

            return supportRepository.save(update);
        });
    }

    public void  deleteSupport(Integer supportId){
        supportRepository.deleteById(supportId);
    }

}
