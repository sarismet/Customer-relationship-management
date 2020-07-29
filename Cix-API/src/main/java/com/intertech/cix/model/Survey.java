package com.intertech.cix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@EqualsAndHashCode
@ToString
public class Survey {
    @Id
    private String id;

    @Reference
    private List<Question> questions;
    private String title;
    @JsonProperty("subTitle")
    private String sub_title;
    private boolean publish_results;
    private boolean receive_results;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public boolean isPublish_results() {
        return publish_results;
    }

    public void setPublish_results(boolean publish_results) {
        this.publish_results = publish_results;
    }

    public boolean isReceive_results() {
        return receive_results;
    }

    public void setReceive_results(boolean receive_results) {
        this.receive_results = receive_results;
    }

    public Survey() {
    }
}
