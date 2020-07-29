package com.intertech.cix.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;
@EqualsAndHashCode
@ToString
public class Result {
    private String id;
    private Map<String ,String> result ;

    public Result() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }
}
