package com.intertech.cix.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Document("surveyLog")
@EqualsAndHashCode
@ToString
public class SurveyLog {

    @Id
    private String id;
    private Model_Survey model_survey;

    @CreatedDate
    private LocalDateTime logDate;


    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Model_Survey getModel_survey() { return model_survey; }

    public void setModel_survey(Model_Survey model_survey) {
        this.model_survey = model_survey;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

}
