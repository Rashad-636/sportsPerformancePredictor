package com.radams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

/**
 * The type Favorite team.
 */
@Entity
@Table(name = "favorite_test")
public class FavoriteTeam {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
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

    @OneToMany(mappedBy = "favorite_test", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Team> favoriteTeamsList = new ArrayList<>();

    /**
     * Instantiates a new Favorite team.
     */
    public FavoriteTeam() {
    }

    /**
     * Instantiates a new Favorite team.
     *
     * @param userEmail the user email
     */
    public FavoriteTeam(String userEmail) {
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

    /**
     * Gets favorite teams list.
     *
     * @return the favorite teams list
     */
    public List<Team> getFavoriteTeamsList() {
        return favoriteTeamsList;
    }

    /**
     * Sets favorite teams list.
     *
     * @param favoriteTeamsList the favorite teams list
     */
    public void setFavoriteTeamsList(List<Team> favoriteTeamsList) {
        this.favoriteTeamsList = favoriteTeamsList;
    }

    @Override
    public String toString() {
        return "FavoriteTeam{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", team=" + team +
                ", favoriteTeamsList=" + favoriteTeamsList +
                '}';
    }
}
