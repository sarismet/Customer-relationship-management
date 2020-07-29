package com.intertech.cix.controller;


import com.intertech.cix.model.Survey;
import com.intertech.cix.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private SurveyService surveyService;

    @Autowired
    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/newSurvey")
    public Survey createSurvey(@RequestBody Survey a) {
        return surveyService.createSurvey(a);
    }

    @GetMapping("/id={name}")
    public Optional<Survey> getSurveyById(@PathVariable("name") String a) {
        return surveyService.getById(a);
    }

    @GetMapping
    public List<Survey> getAll() {
        return surveyService.getAll();
    }

    @PutMapping("/update_survey/id={_id}")
    public Survey updateSurveyById(@RequestBody Survey survey,@PathVariable("_id") String id) {return surveyService.updateSurvey(survey,id);}

    @DeleteMapping("/delete_survey/id={id}")
    public void deleteSurveyById(@PathVariable("id") String id){  surveyService.deleteSurvey(id);}
}
