package com.persistence.model;


import javax.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name="gameId", referencedColumnName="id", nullable=false)
    private Game game;


    public Score(){}

    public Score(Game game, String name){
        this.game = game;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }
}
