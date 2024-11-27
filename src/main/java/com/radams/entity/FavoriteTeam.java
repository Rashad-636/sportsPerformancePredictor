package com.radams.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

/**
 * The type Favorite team.
 */
@Entity
@Table(name = "favorite_teams")  // Changed to match your DB table name
public class FavoriteTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    /**
     * Instantiates a new Favorite team.
     */
    public FavoriteTeam() {
    }

    /**
     * Instantiates a new Favorite team.
     *
     * @param user the user
     * @param team the team
     */
    public FavoriteTeam(User user, Team team) {
        this.user = user;
        this.team = team;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
// Getters and Setters
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "FavoriteTeam{" +
                "id=" + id +
                ", teamId=" + (team != null ? team.getId() : "null") +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteTeam that = (FavoriteTeam) o;
        return id == that.id;  // Just compare IDs
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);  // Just use ID
    }

}