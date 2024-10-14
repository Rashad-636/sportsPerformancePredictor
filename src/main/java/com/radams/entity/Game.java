package com.radams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Game.
 */
@Entity
@Table(name = "game_test")
public class Game {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "game_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "team_id",
            foreignKey = @ForeignKey(name = "game_test_team_id_fk")
    )
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "team_id",
            foreignKey = @ForeignKey(name = "game_test_team_id_fk")
    )
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "sport_id",
            foreignKey = @ForeignKey(name = "game_test_sport_id_fk")
    )
    private Sport sport;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Statistics> gameStats = new ArrayList<>();

    /**
     * Instantiates a new Game.
     */
    public Game() {
    }

    /**
     * Instantiates a new Game.
     *
     * @param date the date
     */
    public Game(Date date) {
        this.date = date;
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
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets away team.
     *
     * @return the away team
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * Sets away team.
     *
     * @param awayTeam the away team
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * Gets game stats.
     *
     * @return the game stats
     */
    public List<Statistics> getGameStats() {
        return gameStats;
    }

    /**
     * Sets game stats.
     *
     * @param gameStats the game stats
     */
    public void setGameStats(List<Statistics> gameStats) {
        this.gameStats = gameStats;
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
     * Gets home team.
     *
     * @return the home team
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * Sets home team.
     *
     * @param homeTeam the home team
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", date=" + date +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", sport=" + sport +
                ", gameStats=" + gameStats +
                '}';
    }
}
