package com.intertech.cix.service;


import com.intertech.cix.model.Survey;
import com.intertech.cix.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    private SurveyRepository surveyRepository;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSurveyRepository(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }



    public Survey createSurvey(Survey a) {
        a.setUser(userService.getUser());
        return surveyRepository.insert(a);
    }

    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }

    public Optional<Survey> getById(String id) {
        return surveyRepository.findById(id);
    }

    public Survey updateSurvey(Survey survey, String id) {

        Survey currentSurvey = surveyRepository.findById(id).get();

        currentSurvey.setTitle(survey.getTitle());
        currentSurvey.setQuestions(survey.getQuestions());
        currentSurvey.setSub_title(survey.getSub_title());
        currentSurvey.setUser(survey.getUser());
        

        return surveyRepository.save(currentSurvey);}

    public void deleteSurvey(String id){ surveyRepository.deleteById(id);}


}
