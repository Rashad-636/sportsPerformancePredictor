package com.radams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.*;

/**
 * The type Player.
 */
@Entity
@Table (name = "player")
public class Player {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "team_id",
            foreignKey = @ForeignKey(name = "player_test_team_id_fk")
    )
    private Team team;

    @ManyToOne
    @JoinColumn(name = "sport_id",
            foreignKey = @ForeignKey(name = "player_test_sport_id_fk")
    )
    private Sport sport;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Statistics> playerStats = new ArrayList<>();

    /**
     * Instantiates a new Player.
     */
    public Player() {
    }

    /**
     * Instantiates a new Player.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets team.
     *
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(Team team) {
        this.team = team;
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
     * Gets player stats.
     *
     * @return the player stats
     */
    public List<Statistics> getPlayerStats() {
        return playerStats;
    }

    /**
     * Sets player stats.
     *
     * @param playerStats the player stats
     */
    public void setPlayerStats(List<Statistics> playerStats) {
        this.playerStats = playerStats;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team=" + team +
                ", sport=" + sport +
                ", playerStats=" + playerStats +
                '}';
    }
}
