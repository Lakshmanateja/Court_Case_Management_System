package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.model.CaseDetails;
import com.example.courtcasemanagementsystem.service.CaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseDetailsUpdateAction {

    @Autowired
    private CaseServiceImpl caseService;

    @PutMapping("/caseDetails")
    public ResponseEntity<Object> updateCaseDetails(@RequestBody CaseDetails caseDetails){
        try{
            CaseDetails updatedCaseDetails = caseService.updateCaseDetails(caseDetails);
            return new ResponseEntity<>(updatedCaseDetails, HttpStatus.OK);
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
