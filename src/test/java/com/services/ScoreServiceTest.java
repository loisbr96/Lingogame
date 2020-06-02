//package com.services;
//
//import com.persistence.GameRepository;
//import com.persistence.model.Game;
//import com.persistence.model.GameState;
//import com.persistence.model.Score;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class ScoreServiceTest {
//    @Autowired
//    private GameRepository gameRepository ;
//
//    @Autowired
//    private ScoreService scoreService ;
//
//    public Game getRandomGame() throws Exception {
//        Iterable lengthIndex = gameRepository.findAll();
//        long size = lengthIndex.spliterator().getExactSizeIfKnown() ;
//        long generatedLong = size + (long) (Math.random() * (0 - size));
//        Optional<Game> game = gameRepository.findById(generatedLong);
//        if (!game.isPresent()) {
//            throw new Exception("No game was found");
//        }
//        if(game.get().getState().equals(GameState.WON)){
//            return game.get();
//        }else{
//            return getRandomGame();
//        }
//    }
//
////    @Test
////    public Score addScoreTest() throws Exception {
////        Game game = getRandomGame();
////        assertThat(scoreService.addScore(game.getId(),"testUser"));
////    }
//}
