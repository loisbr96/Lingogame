package com.persistence.model;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int round;

    @Column
    private int score;


    @ManyToOne
    @JoinColumn(name = "wordId")
    private  Word word;

    public Game() {
    }

    public Game(Word word) {
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public Word getWord(int id) {
        return word;
    }

    public int getRound() {
        return round;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Word getWord() {
        return word;
    }


}
