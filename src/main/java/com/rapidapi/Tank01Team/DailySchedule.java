package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailySchedule {
    @JsonProperty("gameID")
    private String gameID;

    @JsonProperty("teamIDAway")
    private String teamIDAway;

    @JsonProperty("away")
    private String awayTeam;

    @JsonProperty("gameDate")
    private String gameDate;

    @JsonProperty("teamIDHome")
    private String teamIDHome;

    @JsonProperty("home")
    private String homeTeam;

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

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
}
