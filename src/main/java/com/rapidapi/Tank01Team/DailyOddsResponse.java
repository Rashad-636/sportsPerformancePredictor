package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DailyOddsResponse {

    @JsonProperty("statusCode")
    private int statusCode;

    @JsonProperty("body")
    private Map<String, DailySchedule> body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, DailySchedule> getBody() {
        return body;
    }

    public void setBody(Map<String, DailySchedule> body) {
        this.body = body;
    }
}
