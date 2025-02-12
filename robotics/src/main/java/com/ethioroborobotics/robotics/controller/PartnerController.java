package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Partner;
import com.ethioroborobotics.robotics.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;

    @PostMapping("/add")
    public ResponseEntity<Partner> addPartner(@RequestBody Partner partner){
        return ResponseEntity.status(HttpStatus.CREATED).body(partnerService.addPartner(partner));
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getAllPartners(){
        return ResponseEntity.ok(partnerService.getAllPartners()) ;
    }

    @GetMapping("/partner/{id}")
    public ResponseEntity<Optional<Partner>> getPartnerById(@PathVariable("id") Integer partnerId){
        return ResponseEntity.status(HttpStatus.OK).body(partnerService.getPartnerById(partnerId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Partner>> updatePartner(@PathVariable("id") Integer partnerId, @RequestBody Partner partner){
        return ResponseEntity.status(HttpStatus.CREATED).body(partnerService.updatePartner(partnerId,partner));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePartnerById(@PathVariable("id") Integer partnerId){

        partnerService.deletePartner(partnerId);
        return ResponseEntity.ok("Partner deleted successfully");
    }

}
