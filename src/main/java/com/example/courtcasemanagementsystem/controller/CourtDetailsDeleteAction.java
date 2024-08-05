package com.example.courtcasemanagementsystem.controller;

import com.example.courtcasemanagementsystem.service.CourtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class CourtDetailsDeleteAction {

    @Autowired
    private CourtServiceImpl courtService;

    @DeleteMapping("/courtDetails")
    public ResponseEntity<Void> deleteCourtDetails(@PathVariable int courtId){
        try{
            courtService.deleteCourtDetails(courtId);
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
