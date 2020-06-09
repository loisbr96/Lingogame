package com.persistence;

import com.persistence.model.Game;
import com.persistence.model.GameState;
import com.persistence.model.Word;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GameUnitTest {

    /**
     * Getters
     */

    @Test
    public void getRounds(){
        Game game = new Game();

        assertThat(game.getRound() == 0);
    }

    @Test
    public void getScore(){
        Game game = new Game();
        assertThat(game.getScore() == 0);
    }

    @Test
    public void getWord(){
        Game game = new Game();
        Word testWord = new Word("testen");
        game.setWord(testWord);
        assertThat(game.getWord()).isEqualTo(testWord);
    }

    @Test
    public void getState(){
        Game game = new Game();
        assertThat(game.getState()).isEqualTo(GameState.PLAYING);
    }

    /**
     * Setters
     */

    @Test
    public void setId(){
        Game game = new Game();
        game.setId((long) 1);
        assertThat(game.getId() == (long) 1);
    }

    @Test
    public void setRounds(){
        Game game = new Game();
        game.setRound(game.getRound() +1 );
        assertThat(game.getRound() == 1);
    }

    @Test
    public void setScore(){
        Game game = new Game();

        game.setScore(100);
        assertThat(game.getScore() == 100);
    }

    @Test
    public void setWord(){
        Game game = new Game();
        Word testWord = new Word("testen");
        game.setWord(testWord);
        assertThat(game.getWord()).isEqualTo(testWord);
    }

    @Test
    public void setStateWon(){
        Game game = new Game();
        game.won();
        assertThat(game.getState()).isEqualTo(GameState.WON);
    }

    @Test
    public void setStateLost(){
        Game game = new Game();
        game.lost();
        assertThat(game.getState()).isEqualTo(GameState.LOST);
    }
}
