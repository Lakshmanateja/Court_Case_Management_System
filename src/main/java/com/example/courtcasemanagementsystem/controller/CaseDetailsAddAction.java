package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.model.CaseDetails;
import com.example.courtcasemanagementsystem.service.CaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;

@RestController
public class CaseDetailsAddAction {

    @Autowired
    private CaseServiceImpl caseService;

    @PostMapping("/caseDetails")
    public ResponseEntity<Object> createCaseDetails(@RequestBody CaseDetails caseDetails){
        try{
            CaseDetails createdCase = caseService.createCaseDetails(caseDetails);
            return new ResponseEntity<>(createdCase, HttpStatus.CREATED);
        }
        catch(InstanceAlreadyExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
