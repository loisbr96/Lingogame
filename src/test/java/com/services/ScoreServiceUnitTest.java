package com.services;

import com.persistence.GameRepository;
import com.persistence.ScoreRepository;
import com.persistence.model.Game;
import com.persistence.model.GameState;
import com.persistence.model.Score;
import com.persistence.model.Word;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

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

    //TODO: finish this testing method
//    @Test
//    public void addScore() throws Exception{
//        ScoreService scoreService = new ScoreService(scoreRepository, gameRepository);
//        Optional<Game> game = gameRepository.findById((long) 1);
//        game.get().setId((long) 1);
//        game.get().won();
//        game.get().setScore(100);
//        System.out.println(game.get().getId());
//        Score score = scoreService.addScore((long) 1, "testuser");
////        assertThat(score.getGame()).isEqualTo(Game.class);
//        assertThat(score.getName().equals("testuser"));
//    }
}

