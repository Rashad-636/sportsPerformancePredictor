package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SportsBook {
    @JsonProperty("sportsBook")
    private String sportsBook;

    @JsonProperty("odds")
    private GameOdds odds;

    public String getSportsBook() {
        return sportsBook;
    }

    public void setSportsBook(String sportsBook) {
        this.sportsBook = sportsBook;
    }

    public GameOdds getOdds() {
        return odds;
    }

    public void setOdds(GameOdds odds) {
        this.odds = odds;
    }
}
