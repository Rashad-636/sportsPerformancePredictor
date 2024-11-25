package com.radams.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

/**
 * The Sport type.
 */
@Entity
@Table(name = "sports")// case sensitive
public class Sport {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "name")
    private String sportName;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Team> teams = new HashSet<>();

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

    public void addTeam (Team team) {
        teams.add(team);
        team.setSport(this); // sets current sport object by using this keyword
    }

    public void removeTeam(Team team) {
        teams.remove(team);
        team.setSport(null);
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", sportName='" + sportName + '\'' +
                ", teams=" + teams +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return id == sport.id &&
                Objects.equals(sportName, sport.sportName);
        // Note: Cannot compare teams and players ??
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sportName);
    }
}
