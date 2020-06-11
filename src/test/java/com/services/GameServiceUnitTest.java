package com.services;

import com.persistence.GameRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceUnitTest {
    private GameRepository gameRepository;
    private WordService wordService;

    @Before
    public void setUp(){
        this.gameRepository = new GameRepositoryStub();
        this.wordService = new WordService(new WordRepositoryStub());
    }

    @Test
    public void newGame() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);

        Game game = gameService.newGame();
        assertThat(game).isOfAnyClassIn(Game.class);
    }

    @Test
    public void runRoundCorrectWord() {
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        assertThat(gameService.runRound(game, new Word("testen"))).isTrue();
    }

    @Test
    public void runRoundIncorrectWord() {
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        assertThat(gameService.runRound(game, new Word("eerste"))).isFalse();
    }

    @Test
    public void runRoundLongWord() {
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        assertThat(gameService.runRound(game, new Word("abracadaba"))).isFalse();
    }

    @Test
    public void runRoundShortWord(){
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        assertThat(gameService.runRound(game, new Word("test"))).isFalse();
    }

    @Test
    public void runRoundLostGame(){
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));
        game.lost();

        assertThat(gameService.runRound(game, new Word("laptop"))).isFalse();
    }

    @Test
    public void runRoundWonGame() {
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));
        game.won();

        assertThat(gameService.runRound(game, new Word("laptop"))).isFalse();
    }

    @Test
    public void runRoundToMany(){
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));
        game.setRound(6);

        assertThat(gameService.runRound(game, new Word("laptop"))).isFalse();
    }

}
