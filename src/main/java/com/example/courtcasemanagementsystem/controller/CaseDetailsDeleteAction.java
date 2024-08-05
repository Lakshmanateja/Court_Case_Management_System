package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.service.CaseServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class CaseDetailsDeleteAction {

    @Autowired
    private CaseServiceImpl caseService;

    @DeleteMapping("/caseDetails")
    public ResponseEntity<Void> deleteCaseDetails(@PathVariable int caseId, @PathVariable int courtId){
        try{
            caseService.deleteCaseDetails(caseId, courtId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
