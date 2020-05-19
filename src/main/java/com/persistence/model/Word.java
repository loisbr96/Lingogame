package com.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String word;

    public Word(){}

    public Word(String word){
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
