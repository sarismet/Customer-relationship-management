package com.intertech.cix;


import com.intertech.cix.model.Question;
import com.intertech.cix.model.Survey;
import com.intertech.cix.model.User;
import com.intertech.cix.repository.SurveyRepository;
import com.intertech.cix.service.SurveyService;
import com.intertech.cix.service.UserService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static com.intertech.cix.TestHelper.getSurvey;
import static com.intertech.cix.TestHelper.getUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@SpringBootTest
public class SurveyServiceTest {

    private Survey survey1;
    private Survey survey2;
    private Survey survey3;


    @Autowired
    private SurveyService service;

    @MockBean
    private SurveyRepository repository;
    @MockBean
    private UserService userService;

    @BeforeClass
    public void Initialize() {

        List<Question> a = new ArrayList<>();
        a.add(new Question());

        survey1 = new Survey();
        survey1.setTitle("test");
        survey1.setId("5f05bf9320b4285508222b70");
        survey1.setQuestions(a);
        survey1.setPublish_results(true);
        survey1.setReceive_results(true);
        survey1.setSub_title("subtext1");

        survey2 = new Survey();
        survey2.setTitle("test2");
        survey2.setId("6f05bf9320b4285508222b70");
        survey2.setQuestions(a);
        survey2.setPublish_results(true);
        survey2.setReceive_results(true);
        survey2.setSub_title("subtext2");

        survey3 = new Survey();
        survey3.setTitle("test3");
        survey3.setId("7f05bf9320b4285508222b70");
        survey3.setQuestions(a);
        survey3.setPublish_results(true);
        survey3.setReceive_results(true);
        survey3.setSub_title("subtext3");
    }

    @Test
    public void returnSurveyWhenCreate() {

        Survey survey = getSurvey();
        User user = getUser();
        when(repository.insert(survey)).thenReturn(survey);
        when(userService.getUser()).thenReturn(user);

        assertEquals(survey, service.createSurvey(survey));
    }

    @Test
    public void getSurveyByIdIfIdFound() {

        String id = "3f05bf9320b4285508222b70";
        Survey survey = new Survey();
        survey.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(survey));
        assertEquals(survey.getId(), service.getById(id).get().getId());
    }

    @Test
    public void getSurveyByIdIfIdNotFound() {
        String id = "asdasd";
        Survey survey = new Survey();
        survey.setId(id);

        when(repository.findById(id)).thenReturn(null);
        assertEquals(null, service.getById(id));
    }


    @Test
    public void getAll() {

        Initialize();

        when(repository.findAll()).thenReturn(Arrays.asList(survey1, survey2, survey3));

        assertEquals(Arrays.asList(survey1, survey2, survey3), service.getAll());
    }

    @Test
    public void update_whenIdExists() {
        Initialize();
        when(repository.findById(survey1.getId())).thenReturn(Optional.of(survey1));

        Survey survey = new Survey();
        survey.setId("5f05bf9320b4285508222b70");
        survey.setTitle("test");
        List<Question> a = new ArrayList<>();
        a.add(new Question());
        survey.setQuestions(a);
        survey.setPublish_results(true);
        survey.setReceive_results(true);
        survey.setSub_title("aa");


        when(repository.save(survey1)).thenReturn(survey);

        assertEquals(survey, service.updateSurvey(survey, survey1.getId()));

    }

    @Test
    public void update_whenIdNotExists() {
        Initialize();
        when(repository.findById(survey1.getId())).thenThrow(new NoSuchElementException("saas"));

        Exception exception = assertThrows(NoSuchElementException.class, () ->
                service.updateSurvey(survey1, survey1.getId()));

        assertEquals("saas", exception.getMessage());

    }


}
