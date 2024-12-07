package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailySchedule {

    @JsonProperty("gameID")
    private String gameID;

    @JsonProperty("teamIDAway")
    private String teamIDAway;

    @JsonProperty("awayTeam")
    private String awayTeam;

    @JsonProperty("gameDate")
    private String gameDate;

    @JsonProperty("teamIDHome")
    private String teamIDHome;

    @JsonProperty("homeTeam")
    private String homeTeam;

    @JsonProperty("sportsBooks")
    private List<SportsBook> sportsBooks;

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

    public List<SportsBook> getSportsBooks() {
        return sportsBooks;
    }

    public void setSportsBooks(List<SportsBook> sportsBooks) {
        this.sportsBooks = sportsBooks;
    }
}
