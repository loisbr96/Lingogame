package com.services;

import com.persistence.GameRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GameServiceUnitTest {
    private GameRepository gameRepository;
    private WordService wordService;
    private WordRepositoryStub wordRepositoryStub;

    @Before
    public void setUp(){
        this.gameRepository = new GameRepositoryStub();
        this.wordService = new WordService(wordRepositoryStub);
    }

//    @Test
//    public void newGame() throws Exception{
//        GameService gameService = new GameService(gameRepository, wordService);
//
//        Game game = gameService.newGame();
//        assertThat(game).isOfAnyClassIn(Game.class);
//    }

    @Test(expected = Exception.class)
    public void runRoundCorrectWord() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        assertThat(gameService.runRound(game, new Word("testen"))).isTrue();
    }

    @Test
    public void runRoundIncorrectWord() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        assertThat(gameService.runRound(game, new Word("eerste"))).isFalse();
    }

    @Test(expected = Exception.class)
    public void runRoundLongWord() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        gameService.runRound(game, new Word("abracadaba"));
    }

    @Test(expected = Exception.class)
    public void runRoundShortWord() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));

        gameService.runRound(game, new Word("test"));
    }

    @Test(expected = Exception.class)
    public void runRoundLostGame() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));
        game.lost();

        gameService.runRound(game, new Word("laptop"));
    }

    @Test(expected = Exception.class)
    public void runRoundWonGame() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));
        game.won();

        gameService.runRound(game, new Word("laptop"));
    }

    @Test(expected = Exception.class)
    public void runRoundToMany() throws Exception{
        GameService gameService = new GameService(gameRepository, wordService);
        Game game = new Game();
        game.setWord(new Word("testen"));
        game.setRound(6);

        gameService.runRound(game, new Word("laptop"));
    }

}
