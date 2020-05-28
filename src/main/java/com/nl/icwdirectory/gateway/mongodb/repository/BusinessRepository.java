package com.nl.icwdirectory.gateway.mongodb.repository;

import com.nl.icwdirectory.gateway.mongodb.entity.BusinessDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessRepository extends MongoRepository<BusinessDocument, String> {

}
