package com.intertech.cix;

import com.intertech.cix.model.Option;
import com.intertech.cix.model.Question;
import com.intertech.cix.model.QuestionType;
import com.intertech.cix.repository.QuestionRepository;
import com.intertech.cix.service.QuestionService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.Optional;


@SpringBootTest
public class QuestionServiceTest {

    public static Question question1,question2,updatedQuestion;

    @Autowired
    private QuestionService questionService;

    @MockBean
    private QuestionRepository questionRepository;

    @BeforeClass
    public void initSetup(){

        question1 = new Question();
        question1.setId("testID1");
        question1.setTitle("Did you satisfied about our new system?");
        question1.setType(QuestionType.DROPDOWN);
        Option firstOption = new Option();
        firstOption.setId("testOptionID11");
        firstOption.setContent("Yes");
        Option secondOption = new Option();
        secondOption.setId("testOptionID21");
        secondOption.setContent("No");
        question1.setOptions(Arrays.asList(firstOption,secondOption));


        question2 = new Question();
        question2.setId("testID2");
        question2.setTitle("Did you have any problems about transaction");
        question2.setType(QuestionType.CHECKBOXES);
        question2.setOptions(Arrays.asList(firstOption,secondOption));


        updatedQuestion = new Question();
        updatedQuestion.setTitle("Did you satisfied about our new system?");
        updatedQuestion.setType(QuestionType.CHECKBOXES);
        Option newOption1 = new Option();
        newOption1.setId("Smiley");
        newOption1.setContent("😀");
        Option newOption2 = new Option();
        newOption2.setId("Worried");
        newOption2.setContent("😕");
        Option newOption3 = new Option();
        newOption3.setId("Angry");
        newOption3.setContent("😠");
        updatedQuestion.setOptions(Arrays.asList(newOption1,newOption2,newOption3));


    }

    @Test
    public void createQuestionTest(){

        initSetup();

        when(questionRepository.insert(question1)).thenReturn(question1);

        assertEquals(question1,questionService.createQuestion(question1));

    }

    @Test
    public void getAllQuestions_AfterCreateTwoQuestion(){

        initSetup();

        when(questionRepository.findAll()).thenReturn(Arrays.asList(question1,question2));

        assertEquals(Arrays.asList(question1,question2),questionService.getAll());


    }

    @Test
    public void getQuestionByTitleTest(){

        initSetup();

        when(questionRepository.findByTitle(question1.getTitle())).thenReturn(question1);

        assertEquals(question1,questionService.getQuestionByTitle(question1.getTitle()));
    }

    @Test
    public void updateQuestionTest_AfterQuestion1Changed(){

        initSetup();

        when(questionRepository.findById(question1.getId())).thenReturn(Optional.of(question1));
        when(questionRepository.save(question1)).thenReturn(updatedQuestion);

        assertEquals(updatedQuestion,questionService.updateQuestion(question1.getId(),updatedQuestion));

    }

}
