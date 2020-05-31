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

    @Enumerated(EnumType.STRING)
    @Column
    private GameState state;


    @ManyToOne
    @JoinColumn(name = "wordId")
    private Word word;

//    public Game() {
//    }

    public Game() {
        this.state = GameState.PLAYING;
    }

    public Long getId() {
        return id;
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

    public void setRound(int round) {
        this.round = round;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Word getWord() {
        return word;
    }

    public GameState getState() {
        return state;
    }

    public void won(){
        this.state = GameState.WON;
    }

    public void lost(){
        this.state = GameState.LOST;
    }

    public boolean hadEnded(){
        return this.state.equals(GameState.LOST) || this.state.equals(GameState.WON);
    }

}
