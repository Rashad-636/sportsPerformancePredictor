package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DailyScheduleResponse {

    @JsonProperty("statusCode")
    private int statusCode;

    @JsonProperty("body")
    private List<DailySchedule> body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<DailySchedule> getBody() {
        return body;
    }

    public void setBody(List<DailySchedule> body) {
        this.body = body;
    }
}
