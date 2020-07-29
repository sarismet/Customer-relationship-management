package com.intertech.cix;

import com.intertech.cix.model.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestHelper {
    public static Option getOption(){
        Option option =new Option();
        option.setContent("testOption");
        option.setId("1");
        return option;
    }
    public static Option getOption2(){
        Option option =new Option();
        option.setContent("testOption2");
        option.setId("2");
        return option;
    }
    public static Question getQuestionMultiChoice(){
        Question question =new Question();
        question.setId("1");
        question.setType(QuestionType.MULTI_CHOICE);
        question.setTitle("Test Multi Choice Question");
        question.setOptions(Arrays.asList(getOption(),getOption2()));
        return question;
    }
    public static Question getQuestionDropdown(){
        Question question =new Question();
        question.setId("2");
        question.setType(QuestionType.DROPDOWN);
        question.setTitle("Test Dropdown Question");
        question.setOptions(Arrays.asList(getOption(),getOption2()));
        return question;
    }
    public static Question getQuestionCheckBox(){
        Question question =new Question();
        question.setId("3");
        question.setType(QuestionType.CHECKBOXES);
        question.setTitle("Test Check box Question");
        question.setOptions(Arrays.asList(getOption(),getOption2()));
        return question;
    }
    public static Question getQuestionMultiLine(){
        Question question =new Question();
        question.setId("4");
        question.setType(QuestionType.MULTI_LINE_TEXT);
        question.setTitle("Test Multi Line Question");
        return question;
    }
    public static Question getQuestionSingleLine(){
        Question question =new Question();
        question.setId("5");
        question.setType(QuestionType.SINGLE_LINE_TEXT);
        question.setTitle("Test Single Line Question");
        return question;
    }

    public static Survey getSurvey(){
        Survey survey= new Survey();
        survey.setId("s1");
        survey.setTitle("Test Survey Title");
        survey.setQuestions(Arrays.asList(
                getQuestionCheckBox(),
                getQuestionDropdown(),
                getQuestionMultiLine(),
                getQuestionSingleLine(),
                getQuestionMultiChoice()));
        survey.setSub_title("Test Survey Subtitle");
        return survey;
    }
    public static Answer getAnswerMultiChoice(){
        Answer answer=new Answer();
        answer.setQuestionId("1");
        answer.setGivenAnswer("1");
        return answer;
    }
    public static Answer getAnswerDropdown(){
        Answer answer=new Answer();
        answer.setQuestionId("2");
        answer.setGivenAnswer("1");
        return answer;
    }
    public static Answer getAnswerCheckBox(){
        Answer answer=new Answer();
        answer.setQuestionId("3");
        answer.setGivenAnswer("1");
        return answer;
    }
    public static Answer getAnswerMultiLine(){
        Answer answer=new Answer();
        answer.setQuestionId("4");
        answer.setGivenAnswer("Test Multi Line Answer\n Second Line");
        return answer;
    }
    public static Answer getAnswerSingleLine(){
        Answer answer=new Answer();
        answer.setQuestionId("5");
        answer.setGivenAnswer("Test Single Line Answer");
        return answer;
    }
    public static Model_Survey getModelSurvey(){
        Model_Survey model_survey = new Model_Survey();
        model_survey.setId("1");
        model_survey.setCustomer_id("c1");
        model_survey.setSurveyid("s1");
        model_survey.setAnswers(Arrays.asList(getAnswerCheckBox(),getAnswerDropdown(),getAnswerMultiChoice(),getAnswerMultiLine(),getAnswerSingleLine()));
        model_survey.setKeep_Answers(getAnswerMap());
        return model_survey;
    }
    public static Map<String,String> getAnswerMap(){
        Map<String,String> map =new HashMap<>();
        map.put(getAnswerCheckBox().getQuestionId()+"["+getAnswerCheckBox().getGivenAnswer()+"]","true");
        map.put(getAnswerDropdown().getQuestionId(),getAnswerDropdown().getGivenAnswer());
        map.put(getAnswerMultiChoice().getQuestionId(),getAnswerMultiChoice().getGivenAnswer());
        map.put(getAnswerMultiLine().getQuestionId(),getAnswerMultiLine().getGivenAnswer());
        map.put(getAnswerSingleLine().getQuestionId(),getAnswerSingleLine().getGivenAnswer());
        return map;
    }

    public static LinkDto getLink(){
        String link = "https://cix-survey.azurewebsites.net/#/surveys/s1/1";
        return new LinkDto(link);
    }
    public static User getUser(){
        User user = new User();
        user.setId("1");
        user.setEmail("aa@gmail.com");
        user.setUsername("testuser");
        return user;
    }
    public static Result getResult(){
        Result result = new Result();
        result.setId("1");
        result.setResult(getAnswerMap());
        return result;
    }
}
