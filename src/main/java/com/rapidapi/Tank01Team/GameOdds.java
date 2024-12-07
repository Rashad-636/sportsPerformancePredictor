package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameOdds {

    @JsonProperty("totalUnder")
    private String totalUnder;

    @JsonProperty("awayTeamSpread")
    private String awayTeamSpread;

    @JsonProperty("awayTeamSpreadOdds")
    private String awayTeamSpreadOdds;

    @JsonProperty("homeTeamSpread")
    private String homeTeamSpread;

    @JsonProperty("homeTeamSpreadOdds")
    private String homeTeamSpreadOdds;

    @JsonProperty("totalOverOdds")
    private String totalOverOdds;

    @JsonProperty("totalUnderOdds")
    private String totalUnderOdds;

    @JsonProperty("awayTeamMLOdds")
    private String awayTeamMLOdds;

    @JsonProperty("homeTeamMLOdds")
    private String homeTeamMLOdds;

    @JsonProperty("totalOver")
    private String totalOver;

    public String getTotalUnder() {
        return totalUnder;
    }

    public void setTotalUnder(String totalUnder) {
        this.totalUnder = totalUnder;
    }

    public String getAwayTeamSpread() {
        return awayTeamSpread;
    }

    public void setAwayTeamSpread(String awayTeamSpread) {
        this.awayTeamSpread = awayTeamSpread;
    }

    public String getAwayTeamSpreadOdds() {
        return awayTeamSpreadOdds;
    }

    public void setAwayTeamSpreadOdds(String awayTeamSpreadOdds) {
        this.awayTeamSpreadOdds = awayTeamSpreadOdds;
    }

    public String getHomeTeamSpread() {
        return homeTeamSpread;
    }

    public void setHomeTeamSpread(String homeTeamSpread) {
        this.homeTeamSpread = homeTeamSpread;
    }

    public String getHomeTeamSpreadOdds() {
        return homeTeamSpreadOdds;
    }

    public void setHomeTeamSpreadOdds(String homeTeamSpreadOdds) {
        this.homeTeamSpreadOdds = homeTeamSpreadOdds;
    }

    public String getTotalOverOdds() {
        return totalOverOdds;
    }

    public void setTotalOverOdds(String totalOverOdds) {
        this.totalOverOdds = totalOverOdds;
    }

    public String getTotalUnderOdds() {
        return totalUnderOdds;
    }

    public void setTotalUnderOdds(String totalUnderOdds) {
        this.totalUnderOdds = totalUnderOdds;
    }

    public String getAwayTeamMLOdds() {
        return awayTeamMLOdds;
    }

    public void setAwayTeamMLOdds(String awayTeamMLOdds) {
        this.awayTeamMLOdds = awayTeamMLOdds;
    }

    public String getHomeTeamMLOdds() {
        return homeTeamMLOdds;
    }

    public void setHomeTeamMLOdds(String homeTeamMLOdds) {
        this.homeTeamMLOdds = homeTeamMLOdds;
    }

    public String getTotalOver() {
        return totalOver;
    }

    public void setTotalOver(String totalOver) {
        this.totalOver = totalOver;
    }
}
