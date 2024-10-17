package com.radams.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Statistics.
 */
@Entity
@Table(name = "stat")
public class Statistics {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @Column(name = "stat_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "stat_type")
    private String statType;

    @Column(name = "value")
    private Double statValue;

    @ManyToOne
    @JoinColumn(name = "player_id",
            foreignKey = @ForeignKey(name = "stat_test_player_id_fk")
    )
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id",
            foreignKey = @ForeignKey(name = "stat_test_game_id_fk")
    )
    private Game game;

    /**
     * Instantiates a new Statistics.
     */
    public Statistics() {
    }

    /**
     * Instantiates a new Statistics.
     *
     * @param statType  the stat type
     * @param statValue the stat value
     */
    public Statistics(String statType, Double statValue) {
        this.statType = statType;
        this.statValue = statValue;
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
     * Gets stat type.
     *
     * @return the stat type
     */
    public String getStatType() {
        return statType;
    }

    /**
     * Sets stat type.
     *
     * @param statType the stat type
     */
    public void setStatType(String statType) {
        this.statType = statType;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets stat value.
     *
     * @return the stat value
     */
    public Double getStatValue() {
        return statValue;
    }

    /**
     * Sets stat value.
     *
     * @param statValue the stat value
     */
    public void setStatValue(Double statValue) {
        this.statValue = statValue;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
    public void setGame(Game game) {
        this.game = game;
    }

//    @Override
//    public String toString() {
//        return "Statistics{" +
//                "id=" + id +
//                ", statType='" + statType + '\'' +
//                ", statValue=" + statValue +
//                ", player=" + player +
//                ", game=" + game +
//                '}';
//    }
}
