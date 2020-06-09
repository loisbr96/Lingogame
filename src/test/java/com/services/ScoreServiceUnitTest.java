package com.services;

import com.persistence.GameRepository;
import com.persistence.ScoreRepository;
import com.persistence.model.Game;
import com.persistence.model.Score;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ScoreServiceUnitTest {
    private ScoreRepository scoreRepository ;
    private GameRepository gameRepository;

    @Before
    public void setUp(){
        this.scoreRepository = new ScoreRepositoryStub();
        this.gameRepository = new GameRepositoryStub();
    }

    @Test
    public void addScore() throws Exception{
        ScoreService scoreService = new ScoreService(scoreRepository, gameRepository);
        Optional<Game> game = gameRepository.findById((long) 1);

        game.get().won();
        game.get().setScore(100);

        Score score = scoreService.addScore((long) 1, "testuser");
        assertThat(score.getGame()).isEqualTo(game.get());
        assertThat(score.getName()).isEqualTo("testuser");
    }
}

