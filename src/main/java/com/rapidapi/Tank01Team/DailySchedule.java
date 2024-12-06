package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailySchedule {
    @JsonProperty("gameID")
    private String gameID;

    @JsonProperty("teamIDAway")
    private String teamIDAway;

    @JsonProperty("away")
    private String away;

    @JsonProperty("gameDate")
    private String gameDate;

    @JsonProperty("teamIDHome")
    private String teamIDHome;

    @JsonProperty("home")
    private String home;

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getTeamIDAway() {
        return teamIDAway;
    }

    public void setTeamIDAway(String teamIDAway) {
        this.teamIDAway = teamIDAway;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getTeamIDHome() {
        return teamIDHome;
    }

    public void setTeamIDHome(String teamIDHome) {
        this.teamIDHome = teamIDHome;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }
}
