package com.radams.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Sport type.
 */
@Entity
@Table(name = "sport")// case sensitive
public class Sport {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @Column(name = "sport_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "sport_name")
    private String sportName;

    @Column(name = "api")
    private String apiEndpoint;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Team> teams = new ArrayList<>();

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<>();

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
    public Sport(String sportName, String apiEndpoint) {
        this.sportName = sportName;
        this.apiEndpoint = apiEndpoint;
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

    public void addTeam (Team team) {
        teams.add(team);
        team.setSport(this); // sets current sport object by using this keyword
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return id == sport.id &&
                Objects.equals(sportName, sport.sportName) &&
                Objects.equals(apiEndpoint, sport.apiEndpoint);
        // Note: Cannot compare teams and players ??
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sportName, apiEndpoint);
    }
}
