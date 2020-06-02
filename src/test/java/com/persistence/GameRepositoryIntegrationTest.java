package com.persistence;

import com.persistence.model.Game;
import com.persistence.model.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class GameRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void findById(){
        //Given

        Game game = new Game();
        entityManager.persist(game);
        entityManager.flush();

        //when
        Optional<Game> found = gameRepository.findById(game.getId());

        //then
        assertThat(found.get().getId()).isEqualTo(game.getId());
    }

    @Test
    public void addCorrectGame(){
        Game game = new Game();
        entityManager.persist(game);
        entityManager.flush();

       assertThat(gameRepository.save(game));
    }

}
