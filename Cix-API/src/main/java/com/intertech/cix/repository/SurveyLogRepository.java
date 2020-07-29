package com.intertech.cix.repository;

import com.intertech.cix.model.SurveyLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyLogRepository extends MongoRepository<SurveyLog,String> {
}
