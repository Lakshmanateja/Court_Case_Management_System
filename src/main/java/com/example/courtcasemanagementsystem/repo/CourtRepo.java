package com.example.courtcasemanagementsystem.repo;

import com.example.courtcasemanagementsystem.model.CourtDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepo extends MongoRepository<CourtDetails, Integer> {

}
