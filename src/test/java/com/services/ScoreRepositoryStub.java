package com.services;

import com.persistence.ScoreRepository;
import com.persistence.model.Game;
import com.persistence.model.Score;
import com.persistence.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScoreRepositoryStub implements ScoreRepository {

    private List<Score> scoreArrayList = new ArrayList<>();

    ScoreRepositoryStub(){
        for(int i = 0; i <4; i++){
            Game game = new Game();
            game.setWord(new Word("testen"));
            game.setScore(100);
            Score score = new Score(game, "testuser");
            scoreArrayList.add(score);
        }
    }

    @Override
    public <S extends Score> S save(S s) {
        scoreArrayList.add(s);
        return s;
    }

    @Override
    public <S extends Score> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Score> findById(Long aLong) {
        int i = Math.toIntExact(aLong);
        return Optional.ofNullable(scoreArrayList.get(i));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Score> findAll() {
        return scoreArrayList;
    }

    @Override
    public Iterable<Score> findAllById(Iterable<Long> iterable) {
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
    public void delete(Score score) {

    }

    @Override
    public void deleteAll(Iterable<? extends Score> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
