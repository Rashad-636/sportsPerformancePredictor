package com.radams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

/**
 * The type Team.
 */
@Entity
@Table(name = "team")
public class Team {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "sport_id",
            foreignKey = @ForeignKey(name = "team_test_sport_id_fk")
    )
    private Sport sport;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<User> favoriteTeams = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Game> homeGames;

    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Game> awayGames;

    /**
     * Instantiates a new Team.
     */
    public Team() {
    }

    /**
     * Instantiates a new Team.
     *
     * @param teamName the team name
     * @param city     the city
     * @param sport    the sport
     */
    public Team(String teamName, String city, Sport sport) {
        this.teamName = teamName;
        this.city = city;
        this.sport = sport;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets team name.
     *
     * @return the team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets team name.
     *
     * @param teamName the team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets sport.
     *
     * @return the sport
     */
    public Sport getSport() {
        return sport;
    }

    /**
     * Sets sport.
     *
     * @param sport the sport
     */
    public void setSport(Sport sport) {
        this.sport = sport;
    }

    /**
     * Gets favorite teams.
     *
     * @return the favorite teams
     */
    public List<User> getFavoriteTeams() {
        return favoriteTeams;
    }

    /**
     * Sets favorite teams.
     *
     * @param favoriteTeams the favorite teams
     */
    public void setFavoriteTeams(List<User> favoriteTeams) {
        this.favoriteTeams = favoriteTeams;
    }

    /**
     * Gets home games.
     *
     * @return the home games
     */
    public List<Game> getHomeGames() {
        return homeGames;
    }

    /**
     * Sets home games.
     *
     * @param homeGames the home games
     */
    public void setHomeGames(List<Game> homeGames) {
        this.homeGames = homeGames;
    }

    /**
     * Gets away games.
     *
     * @return the away games
     */
    public List<Game> getAwayGames() {
        return awayGames;
    }

    /**
     * Sets away games.
     *
     * @param awayGames the away games
     */
    public void setAwayGames(List<Game> awayGames) {
        this.awayGames = awayGames;
    }

    /**
     * Gets players.
     *
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
