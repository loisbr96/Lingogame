//package com.persistence.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//public class Game {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @Column
//    private int round;
//
//    @Column
//    private Word word;
//
//    @Column
//    private int score;
//
//    public Game() {
//    }
//
//    public Game(Word word) {
//        this.word = word;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Word getWord(int id) {
//        return word;
//    }
//
//    public int getRound() {
//        return round;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//}
