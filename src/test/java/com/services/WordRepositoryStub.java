package com.services;

import com.persistence.WordRepository;
import com.persistence.model.Word;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class WordRepositoryStub implements WordRepository {

    private List<Word> wordArrayList = new ArrayList<>();

    WordRepositoryStub(){
        wordArrayList.add(new Word("testen"));
        wordArrayList.add(new Word("laptop"));
        wordArrayList.add(new Word("ahahah"));
    }


    @Override
    public Word findById(Word id){


        return null;
    }

    @Override
    public <S extends Word> S save(S s) {
        return s;
    }

    @Override
    public <S extends Word> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Word> findById(Long aLong) {
        int i = Math.toIntExact(aLong);
        return Optional.ofNullable(wordArrayList.get(i));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Word> findAll() {

        return wordArrayList;
    }

    @Override
    public Iterable<Word> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Word word) {

    }

    @Override
    public void deleteAll(Iterable<? extends Word> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
