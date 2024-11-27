package com.radams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

/**
 * The type Team.
 */
@Entity
@Table(name = "teams")
public class Team {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "team_name")
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "sport_id",
            foreignKey = @ForeignKey(name = "favorite_teams_sports_id_fk")
    )
    private Sport sport;

    /**
     * Instantiates a new Team.
     */
    public Team() {
    }

    /**
     * Instantiates a new Team.
     *
     * @param teamName the team name
     * @param sport    the sport
     */
    public Team(String teamName, Sport sport) {
        this.teamName = teamName;
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


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + teamName + '\'' +
                ", sport=" + (sport != null ? sport.getSportName() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id && Objects.equals(teamName, team.teamName) && Objects.equals(sport, team.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, sport);
    }
}
