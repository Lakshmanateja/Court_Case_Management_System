package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.model.CourtDetails;
import com.example.courtcasemanagementsystem.service.CourtService;
import com.example.courtcasemanagementsystem.service.CourtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;

@RestController
public class CourtDetailsAddAction {

    @Autowired
    private CourtServiceImpl courtService;

    @PostMapping("/courtDetails")
    public ResponseEntity<Object> createCourtDetails(@RequestBody CourtDetails courtDetails){
        try{
            CourtDetails createdCourt = courtService.createCourtDetails(courtDetails);
            return new ResponseEntity<>(createdCourt, HttpStatus.CREATED);
        }
        catch(InstanceAlreadyExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
