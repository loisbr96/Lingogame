package com.persistence.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class Scoreboard {
    @Column
    private String name;

    @OneToOne
    @JoinColumn(name="gameId", referencedColumnName="id", nullable=true)
    private Game game;


    Scoreboard(){}

    Scoreboard(Game game, String name){
        this.game = game;
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
