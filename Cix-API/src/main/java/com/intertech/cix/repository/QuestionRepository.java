package com.intertech.cix.repository;


import com.intertech.cix.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {

    public Question findByTitle(String name);
}
