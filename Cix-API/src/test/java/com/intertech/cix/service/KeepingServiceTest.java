package com.intertech.cix.service;

import com.intertech.cix.exception.bad_request.SurveyIdUniqueIdMissMatchException;
import com.intertech.cix.exception.not_found.ResourceNotFoundException;
import com.intertech.cix.generic.CustomMessageSource;
import com.intertech.cix.model.LinkDto;
import com.intertech.cix.model.Model_Survey;
import com.intertech.cix.model.Result;
import com.intertech.cix.repository.KeepRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.intertech.cix.TestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KeepingServiceTest {

    @InjectMocks
    private KeepingService keepingService;

    @Mock
    private KeepRepository keepAnswerRepository;
    @Mock
    private CustomMessageSource messageSource;
    @Mock
    private SurveyLogService surveyLogService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldThrowEntityNotFoundExceptionWhenGetSurveyWithLinkIfThereIsNoSuchSurveyRecord(){
        String invalidSurveyId ="asasfsa";
        String invalidUniqueId="asdsadas";

        when(keepAnswerRepository.findById(invalidUniqueId)).thenReturn(Optional.empty());
        when(messageSource.getMessage("error.model-survey.does-not-exist")).thenReturn("error");

        assertThrows(ResourceNotFoundException.class,() -> keepingService.check(invalidSurveyId,invalidUniqueId));
    }

    @Test
    public void shouldThrowSurveyIdMissMatchExceptionWhenGetSurveyWithLinkIfThereIsNoSuchSurveyRecord(){
        String invalidSurveyId ="asasfsa";
        String uniqueId="1";
        Model_Survey model_survey = getModelSurvey();

        when(keepAnswerRepository.findById(uniqueId)).thenReturn(Optional.of(model_survey));
        when(messageSource.getMessage("error.model-survey.id-miss-match")).thenReturn("error");

        assertThrows(SurveyIdUniqueIdMissMatchException.class,() -> keepingService.check(invalidSurveyId,uniqueId));
    }

    @Test
    public void shouldReturnModelSurvey(){
        String surveyId ="s1";
        String uniqueId="1";
        Model_Survey model_survey = getModelSurvey();

        when(keepAnswerRepository.findById(uniqueId)).thenReturn(Optional.of(model_survey));

        assertEquals(ResponseEntity.ok(model_survey), keepingService.check(surveyId,uniqueId));

    }

    @Test
    public void shouldReturnLinkDto(){
        String surveyId ="s1";
        String customerId="c1";
        Model_Survey model_survey = getModelSurvey();
        LinkDto expected = new LinkDto("https://cix-survey.azurewebsites.net/#/surveys/" + model_survey.getSurveyid() + "/" + model_survey.getId());
        when(keepAnswerRepository.insert((Model_Survey) any())).thenReturn(model_survey);

        assertEquals(expected, keepingService.keepSurvey(surveyId,customerId));

    }

    @Test
    public void shouldReturnUpdatedSurveyResult(){
        Model_Survey model_survey = getModelSurvey();

        when(keepAnswerRepository.findById(model_survey.getId())).thenReturn(Optional.of(model_survey));
        when(keepAnswerRepository.save(model_survey)).thenReturn(model_survey);

        assertEquals(model_survey,keepingService.save(model_survey.getKeep_Answers(),model_survey.getId()));

    }

    @Test
    public void shouldReturnResultList(){
        String surveyid="s1";
        List<Model_Survey> model_surveys = Arrays.asList(getModelSurvey(),getModelSurvey());
        List<Result> expected = Arrays.asList(getResult(),getResult());
        when(keepAnswerRepository.findAllBySurveyid(surveyid)).thenReturn(model_surveys);

        assertEquals(expected,keepingService.getResult(surveyid));

    }


}