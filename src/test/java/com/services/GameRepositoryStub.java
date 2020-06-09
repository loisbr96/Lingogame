package com.services;

import com.persistence.GameRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameRepositoryStub implements GameRepository {

    private List<Game> gameArrayList = new ArrayList<>();

    GameRepositoryStub(){
        for(int i = 0; i <4; i++){
            Word word = new Word("testen");
            Game game = new Game();
            game.setId((long)i +1 );
            game.setWord(word);
            gameArrayList.add(game);
        }
    }

    @Override
    public Game findById(Game id) {
        return null;
    }

    @Override
    public <S extends Game> S save(S s) {
        gameArrayList.add(s);
        return s;
    }

    @Override
    public <S extends Game> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Game> findById(Long aLong) {
        int i = Math.toIntExact(aLong);
        return Optional.ofNullable(gameArrayList.get(i));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Game> findAll() {
        return gameArrayList;
    }

    @Override
    public Iterable<Game> findAllById(Iterable<Long> iterable) {
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
    public void delete(Game game) {

    }

    @Override
    public void deleteAll(Iterable<? extends Game> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
