package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Community;
import com.ethioroborobotics.robotics.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommunityService {

    private final CommunityRepository communityRepository;

    public Community addCommunityService(Community community){
        return communityRepository.save(community);
    }

    public List<Community> getAllCommunityService(){
        return communityRepository.findAll();
    }

    public Optional<Community> getCommunityService(Integer id){
        return communityRepository.findById(id);
    }

    public Optional<Community> updateCommunityService(Integer id, Community community){
        return communityRepository.findById(id).map(update->{

            update.setInstitution(community.getInstitution());
            update.setProgramName(community.getProgramName());
            update.setSponsoredStudents(community.getSponsoredStudents());
            update.setProgramDetails(community.getProgramDetails());
            update.setCurrentStatus(community.getCurrentStatus());
            update.setStartDate(community.getStartDate());
            update.setEndDate(community.getEndDate());

            return communityRepository.save(update);
        });
    }

    public void deleteCommunityService(Integer id){
        communityRepository.deleteById(id);
    }

}
