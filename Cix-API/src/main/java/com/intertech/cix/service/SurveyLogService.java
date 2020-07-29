package com.intertech.cix.service;

import com.intertech.cix.model.SurveyLog;
import com.intertech.cix.repository.SurveyLogRepository;
import com.intertech.cix.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyLogService {
    private SurveyLogRepository surveyLogRepository;

    @Autowired
    public void setSurveyLogRepository(SurveyLogRepository surveyLogRepository) { this.surveyLogRepository = surveyLogRepository; }

    public SurveyLog addSurveyLog(SurveyLog surveyLog){
        return surveyLogRepository.insert(surveyLog);
    }
}
