package com.radams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

/**
 * The type Favorite team.
 */
@Entity
@Table(name = "user")
public class User {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "user_email")
    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "team_id",
            foreignKey = @ForeignKey(name = "favorite_test_team_id_fk")
    )
    private Team team;

    /**
     * Instantiates a new Favorite team.
     */
    public User() {
    }

    /**
     * Instantiates a new Favorite team.
     *
     * @param userEmail the user email
     */
    public User(String userEmail) {
        this.userEmail = userEmail;
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
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email.
     *
     * @param userEmail the user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

//    @Override
//    public String toString() {
//        return "FavoriteTeam{" +
//                "id=" + id +
//                ", userEmail='" + userEmail + '\'' +
//                ", team=" + team +
//                '}';
//    }

    @Override
    public String toString() {
        return "User{" +
                "favorite_id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", team=" + (team != null ? "Team{id=" + team.getId() + "}" : "null") +
                '}';
    }

    /// !!!!!!!!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(team != null ? team.getId() : null, that.team != null ? that.team.getId() : null);
    }

    /// !!!!!!!!!!
    @Override
    public int hashCode() {
        return Objects.hash(id, userEmail, team != null ? team.getId() : null);
    }
}
