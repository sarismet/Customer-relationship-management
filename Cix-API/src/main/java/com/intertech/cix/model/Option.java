package com.intertech.cix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Option {
    private String content;
    @JsonProperty("_id")
    private String id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public Option() {
    }

    public void setId(String id) {
        this.id = id;
    }
}
