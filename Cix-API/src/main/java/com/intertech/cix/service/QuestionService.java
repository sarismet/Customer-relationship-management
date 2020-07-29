package com.intertech.cix.service;


import com.intertech.cix.exception.not_found.ResourceNotFoundException;
import com.intertech.cix.generic.CustomMessageSource;
import com.intertech.cix.model.Question;
import com.intertech.cix.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private CustomMessageSource messageSource;

    @Autowired
    public void setMessageSource(CustomMessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question a) {
        return questionRepository.insert(a);
    }

    public Question getQuestionByTitle(String a) {
        return questionRepository.findByTitle(a);
    }
    
    public Optional<Question> getQuestionById(String a) {
        return questionRepository.findById(a);
    }

    public Question updateQuestion(String id, Question a) {


        Question question = questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(messageSource.getMessage(QUESTION_DOES_NOT_EXIST)));
        question.setTitle(a.getTitle());
        question.setType(a.getType());
        question.setOptions(a.getOptions());
        question.setPlaceholder(a.getPlaceholder());
        return questionRepository.save(question);
    }


    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    private static final String QUESTION_DOES_NOT_EXIST = "error.question.does-not-exist";

}
