package com.persistence.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Length(min = 5, max = 7)
    @Pattern(regexp = "^[a-z]*$")
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
