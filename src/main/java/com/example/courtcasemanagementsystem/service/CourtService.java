package com.example.courtcasemanagementsystem.service;

import com.example.courtcasemanagementsystem.model.CourtDetails;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;

public interface CourtService {
    CourtDetails createCourtDetails(CourtDetails courtDetails) throws InstanceAlreadyExistsException;
    CourtDetails getCourtById(int courtId);
    List<CourtDetails> getAllCourtDetails();
    CourtDetails updateCourtDetails(CourtDetails courtDetails) throws IllegalArgumentException;
    void deleteCourtDetails(int courtId) throws NoSuchElementException;
    void updateCaseIdInCourtDetails(int caseId, int courtId) throws NoSuchElementException;
    void deleteCaseIdInCourtDetails(int caseId, int courtId) throws NoSuchElementException;
}
