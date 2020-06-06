package com.persistence;

import com.persistence.model.Game;
import com.persistence.model.Score;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ScoreRepositoryUnitTest {

    /**
     * Getters
     */

    @Test
    public void getName(){
        Score score = new Score(new Game(), "testuser");

        assertThat(score.getName().equals("testuser"));
    }

    @Test
    public void getGame(){
        Game game = new Game();
        Score score = new Score(game, "testuser");

        assertThat(score.getGame()).isEqualTo(game);
    }

    /**
     * Setters
     */

    @Test
    public void setName(){
        Score score = new Score(new Game(), "");
        score.setName("testuser");
        assertThat(score.getName().equals("testuser"));
    }

    @Test
    public void setGame(){
        Game game = new Game();
        Score score = new Score(game, "testuser");
        Game game2 = new Game();
        score.setGame(game2);

        assertThat(score.getGame()).isEqualTo(game2);
    }
}
