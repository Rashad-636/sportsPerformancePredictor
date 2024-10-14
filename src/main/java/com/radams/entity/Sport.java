package com.radams.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The Sport type.
 */
@Entity
@Table(name = "sport")// case sensitive
public class Sport {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "sport_name")
    private String sportName;

    @Column(name = "api_endpoint")
    private String apiEndpoint;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sport> teams = new ArrayList<>();

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sport> players = new ArrayList<>();

    /**
     * Instantiates a new Sport.
     */
    public Sport() {
    }

    /**
     * Instantiates a new Sport.
     *
     * @param sportName   the sport name
     */
    public Sport(String sportName) {
        this.sportName = sportName;
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
     * Gets players.
     *
     * @return the players
     */
    public List<Sport> getPlayers() {
        return players;
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(List<Sport> players) {
        this.players = players;
    }

    /**
     * Gets teams.
     *
     * @return the teams
     */
    public List<Sport> getTeams() {
        return teams;
    }

    /**
     * Sets teams.
     *
     * @param teams the teams
     */
    public void setTeams(List<Sport> teams) {
        this.teams = teams;
    }

    /**
     * Gets api endpoint.
     *
     * @return the api endpoint
     */
    public String getApiEndpoint() {
        return apiEndpoint;
    }

    /**
     * Sets api endpoint.
     *
     * @param apiEndpoint the api endpoint
     */
    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    /**
     * Gets sport name.
     *
     * @return the sport name
     */
    public String getSportName() {
        return sportName;
    }

    /**
     * Sets sport name.
     *
     * @param sportName the sport name
     */
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", sportName='" + sportName + '\'' +
                ", apiEndpoint='" + apiEndpoint + '\'' +
                ", teams=" + teams +
                ", players=" + players +
                '}';
    }
}
