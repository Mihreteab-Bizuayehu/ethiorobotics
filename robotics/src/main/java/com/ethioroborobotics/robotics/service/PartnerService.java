package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Partner;
import com.ethioroborobotics.robotics.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;

    public Partner addPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    public List<Partner> getAllPartners(){
        return partnerRepository.findAll();
    }

    public Optional<Partner> getPartnerById(Integer partnerId){
        return partnerRepository.findById(partnerId);
    }

    public Optional<Partner> updatePartner(Integer partnerId,Partner partner){
        return partnerRepository.findById(partnerId).map(updatedPartner->{
            updatedPartner.setPartnerName(partner.getPartnerName());
            updatedPartner.setContactEmail(partner.getContactEmail());
            updatedPartner.setDescription(partner.getDescription());
            updatedPartner.setContactPerson(partner.getContactPerson());
            updatedPartner.setContactPhone(partner.getContactPhone());

            return partnerRepository.save(updatedPartner);
        });
    }

    public void deletePartner(Integer partnerId){
        partnerRepository.deleteById(partnerId);
    }

}
