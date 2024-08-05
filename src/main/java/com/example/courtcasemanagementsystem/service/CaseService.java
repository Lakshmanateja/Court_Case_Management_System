package com.example.courtcasemanagementsystem.service;

import com.example.courtcasemanagementsystem.model.CaseDetails;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;

public interface CaseService {
    CaseDetails createCaseDetails(CaseDetails caseDetails) throws InstanceAlreadyExistsException;
    CaseDetails getCaseById(int caseId);
    List<CaseDetails> getAllCaseDetails();
    CaseDetails updateCaseDetails(CaseDetails caseDetails) throws IllegalArgumentException;
    void deleteCaseDetails(int caseId, int courtId) throws NoSuchElementException;
    void updateNumberOfDays();
}
