package com.intertech.cix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document
@EqualsAndHashCode
@ToString
public class Model_Survey {

    @Id
    @JsonProperty("_id")
    private String id;
    @JsonProperty("survey_id")
    @Field("survey_id")
    private String surveyid;
    private String customer_id;

    @CreatedDate
    private LocalDateTime created_date;

    @LastModifiedDate
    private LocalDateTime updated_date;

    public LocalDateTime getCreated_date() { return created_date; }

    public void setCreated_date(LocalDateTime created_date) { this.created_date = created_date; }

    public LocalDateTime getUpdated_date() { return updated_date; }

    public void setUpdated_date(LocalDateTime updated_date) { this.updated_date = updated_date; }

    Map<String, String> keep_Answers;
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getId(){return this.id;}
    public String getSurveyid(){return this.surveyid;}
    public String getCustomer_id(){return  this.customer_id;}

    public void setId(String id){this.id = id;}
    public void setCustomer_id(String customer_id){this.customer_id= customer_id;}
    public void setSurveyid(String surveyid){this.surveyid = surveyid;}

    public Map<String,String> getKeep_Answers(){return this.keep_Answers;}
    public void setKeep_Answers(Map<String, String> keep_Answers){this.keep_Answers=keep_Answers;}


    public Model_Survey() {
    }
}
