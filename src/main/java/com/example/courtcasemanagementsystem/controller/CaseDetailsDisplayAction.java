package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.model.CaseDetails;
import com.example.courtcasemanagementsystem.service.CaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaseDetailsDisplayAction {

    @Autowired
    private CaseServiceImpl caseService;

    @GetMapping("/caseDetails/{caseId}")
    public ResponseEntity<CaseDetails> getCaseById(@PathVariable int caseId){
        CaseDetails caseDetails = caseService.getCaseById(caseId);

        if(caseDetails!=null){
            return new ResponseEntity<>(caseDetails, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/caseDetails")
    public List<CaseDetails> getAllCaseDetails(){
        return caseService.getAllCaseDetails();
    }
}
