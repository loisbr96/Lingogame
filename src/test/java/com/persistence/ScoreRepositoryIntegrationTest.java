//package com.persistence;
//
//import com.persistence.model.Game;
//import com.persistence.model.Score;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ScoreRepositoryIntegrationTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private ScoreRepository scoreRepository;
//
//    @Autowired
//    Game game;
//
//    @Test
//    public void findById(){
//        //Given
//        Score score = new Score(game, "testUser");
//        entityManager.persist(score);
//        entityManager.flush();
//
//        //when
//        Optional<Score> found = scoreRepository.findById(score.getId());
//
//        //then
//        assertThat(found.get().getId()).isEqualTo(score.getId());
//    }
//
//    @Test
//    public void addCorrectScore(){
//        Score score = new Score();
//        entityManager.persist(score);
//        entityManager.flush();
//
//       assertThat(scoreRepository.save(score));
//    }
//
//}
