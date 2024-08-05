package com.example.courtcasemanagementsystem.repo;

import com.example.courtcasemanagementsystem.model.CaseDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepo extends MongoRepository<CaseDetails, Integer> {

}
