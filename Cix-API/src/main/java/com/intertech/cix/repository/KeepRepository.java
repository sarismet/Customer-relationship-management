package com.intertech.cix.repository;


import com.intertech.cix.model.Model_Survey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeepRepository extends MongoRepository<Model_Survey, String> {

    List<Model_Survey> findAllBySurveyid(String survey_id);

}
