package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.model.CourtDetails;
import com.example.courtcasemanagementsystem.service.CourtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourtDetailsDisplayAction {

    @Autowired
    private CourtServiceImpl courtService;

    @GetMapping("/courtDetails/{courtId}")
    public ResponseEntity<CourtDetails> getCourtDetailsById(@PathVariable int courtId){
        CourtDetails courtDetails = courtService.getCourtById(courtId);

        if(courtDetails!=null){
            return new ResponseEntity<>(courtDetails, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/courtDetails")
    public List<CourtDetails> getAllCourtDetails(){
        return courtService.getAllCourtDetails();
    }
}
