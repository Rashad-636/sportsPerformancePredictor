package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailySchedule {

    @JsonProperty("last_updated_e_time")
    private String lastUpdatedETime;

    @JsonProperty("gameID")
    private String gameID;

    @JsonProperty("betmgm")
    private GameOdds betmgm;

    @JsonProperty("bet365")
    private GameOdds bet365;

    @JsonProperty("fanduel")
    private GameOdds fanduel;

    @JsonProperty("draftkings")
    private GameOdds draftkings;

    @JsonProperty("caesars_sportsbook")
    private GameOdds caesarsSportsbook;

    @JsonProperty("betrivers")
    private GameOdds betrivers;

    @JsonProperty("ballybet")
    private GameOdds ballybet;

    @JsonProperty("espnbet")
    private GameOdds espnbet;

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

    public String getLastUpdatedETime() {
        return lastUpdatedETime;
    }

    public void setLastUpdatedETime(String lastUpdatedETime) {
        this.lastUpdatedETime = lastUpdatedETime;
    }

    public GameOdds getBetmgm() {
        return betmgm;
    }

    public void setBetmgm(GameOdds betmgm) {
        this.betmgm = betmgm;
    }

    public GameOdds getFanduel() {
        return fanduel;
    }

    public void setFanduel(GameOdds fanduel) {
        this.fanduel = fanduel;
    }

    public GameOdds getEspnbet() {
        return espnbet;
    }

    public void setEspnbet(GameOdds espnbet) {
        this.espnbet = espnbet;
    }

    public GameOdds getBallybet() {
        return ballybet;
    }

    public void setBallybet(GameOdds ballybet) {
        this.ballybet = ballybet;
    }

    public GameOdds getBetrivers() {
        return betrivers;
    }

    public void setBetrivers(GameOdds betrivers) {
        this.betrivers = betrivers;
    }

    public GameOdds getBet365() {
        return bet365;
    }

    public void setBet365(GameOdds bet365) {
        this.bet365 = bet365;
    }

    public GameOdds getDraftkings() {
        return draftkings;
    }

    public void setDraftkings(GameOdds draftkings) {
        this.draftkings = draftkings;
    }

    public GameOdds getCaesarsSportsbook() {
        return caesarsSportsbook;
    }

    public void setCaesarsSportsbook(GameOdds caesarsSportsbook) {
        this.caesarsSportsbook = caesarsSportsbook;
    }
}
