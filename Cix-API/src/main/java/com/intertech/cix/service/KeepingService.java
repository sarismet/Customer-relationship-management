package com.intertech.cix.service;


import com.intertech.cix.exception.bad_request.SurveyIdUniqueIdMissMatchException;
import com.intertech.cix.exception.not_found.ResourceNotFoundException;
import com.intertech.cix.generic.CustomMessageSource;
import com.intertech.cix.model.*;
import com.intertech.cix.repository.KeepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KeepingService {

    private KeepRepository keepAnswerRepository;
    private CustomMessageSource messageSource;
    private SurveyLogService surveyLogService;

    @Autowired
    public void setSurveyLogService(SurveyLogService surveyLogService) {
        this.surveyLogService = surveyLogService;
    }

    @Autowired
    public void setMessageSource(CustomMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setKeepRepository(KeepRepository keepAnswerRepository) {
        this.keepAnswerRepository = keepAnswerRepository;
    }

    public LinkDto keepSurvey(String surveyid, String customerid) {
        Model_Survey model_survey = new Model_Survey();
        model_survey.setCustomer_id(customerid);
        model_survey.setSurveyid(surveyid);
        Model_Survey a = keepAnswerRepository.insert(model_survey);
        String link = "https://cix-survey.azurewebsites.net/#/surveys/" + a.getSurveyid() + "/" + a.getId();
        return new LinkDto(link);
    }

    public Model_Survey save(Map<String, String> answers, String id) {
        Model_Survey old_Answers = keepAnswerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage(MODEL_SURVEY_DOES_NOT_EXIST)));
        old_Answers.setKeep_Answers(answers);
        old_Answers.setAnswers(new ArrayList<>());
        for (String i : answers.keySet()) {
            String[] parsed = i.split("[\\[,\\]]");
            Answer answer = new Answer();
            answer.setQuestionId(parsed[0]);
            if (parsed.length == 2) {
                answer.setGivenAnswer(parsed[1]);
            } else {
                answer.setGivenAnswer(answers.get(i));
            }
            old_Answers.getAnswers().add(answer);
        }

        SurveyLog surveyLog = new SurveyLog();
        surveyLog.setModel_survey(old_Answers);
        surveyLogService.addSurveyLog(surveyLog);

        return keepAnswerRepository.save(old_Answers);
    }


    public ResponseEntity<Model_Survey> check(String surveyId, String uniqueId) {
        Model_Survey old_Answers = keepAnswerRepository.findById(uniqueId).orElseThrow(() -> new ResourceNotFoundException(messageSource.getMessage(MODEL_SURVEY_DOES_NOT_EXIST)));
        if (!old_Answers.getSurveyid().equals(surveyId)) throw new SurveyIdUniqueIdMissMatchException(messageSource.getMessage(MODEL_SURVEY_MISS_MATCH));
        return ResponseEntity.ok(old_Answers);
    }

    public List<Result> getResult(String survey_id) {
        List<Model_Survey> res = keepAnswerRepository.findAllBySurveyid(survey_id);
        List<Result> results = new ArrayList<>();
        for (Model_Survey i : res) {
            if (i.getKeep_Answers() != null && !i.getKeep_Answers().isEmpty()) {
                Result temp = new Result();
                temp.setId(i.getId());
                temp.setResult(i.getKeep_Answers());
                results.add(temp);
            }
        }
        return results;
    }

    private static final String MODEL_SURVEY_DOES_NOT_EXIST = "error.model-survey.does-not-exist";
    private static final String MODEL_SURVEY_MISS_MATCH = "error.model-survey.id-miss-match";
}
