package com.persistence;

import com.persistence.model.Game;
import com.persistence.model.Score;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ScoreRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ScoreRepository scoreRepository;

    @Test
    public void findById(){
        //Given
        Game game = new Game();
        entityManager.persist(game);
        entityManager.flush();

        Score score = new Score(game, "testUser");
        entityManager.persist(score);
        entityManager.flush();

        //when
        Optional<Score> found = scoreRepository.findById(score.getId());

        //then
        assertThat(found.get().getId()).isEqualTo(score.getId());
    }

    //TODO: fix the error
    @Test
    public void findAll(){
        //Given
        for (int i = 0; i < 11; i++){
//            Game game = new Game();
//            entityManager.persist(new Game());
//            entityManager.flush();
            Score score = new Score(new Game(), "testUser");
            entityManager.persist(score);
            entityManager.flush();
        }

        //When
        Iterable<Score> found = scoreRepository.findAll();
        List<Score> allScores = new ArrayList<>();
        found.forEach(allScores::add);

        //Then
        assertThat(allScores.size() == 10);
    }

}
