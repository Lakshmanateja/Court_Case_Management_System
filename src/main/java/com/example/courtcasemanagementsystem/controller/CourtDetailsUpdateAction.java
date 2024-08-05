package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.model.CourtDetails;
import com.example.courtcasemanagementsystem.service.CourtServiceImpl;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourtDetailsUpdateAction {

    @Autowired
    private CourtServiceImpl courtService;

    @PutMapping("/courtDetails")
    public ResponseEntity<Object> updateCourtDetails(@RequestBody CourtDetails courtDetails){
        try{
            CourtDetails updatedCourtDetails = courtService.updateCourtDetails(courtDetails);
            return new ResponseEntity<>(updatedCourtDetails, HttpStatus.OK);
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
