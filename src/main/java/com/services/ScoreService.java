package com.services;

import com.persistence.GameRepository;
import com.persistence.ScoreRepository;
import com.persistence.model.Game;
import com.persistence.model.GameState;
import com.persistence.model.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final GameRepository gameRepository;

    private static Logger logger = LoggerFactory.getLogger(ScoreService.class);

    public Score addScore(long gameId, String username) throws Exception{
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if (!gameOptional.isPresent()) {
            logger.error("Game not found");
            throw new Exception("Game not found");
        }
        Game game = gameOptional.get();

        Iterable<Score> scores = scoreRepository.findAll();
        for(Score score : scores){
            Game scoreGame = score.getGame();
            if (scoreGame.equals(game)){
                throw new Exception("This game is already on the scoreboard!");
            }
        }

        if(game.getState().equals(GameState.WON)){
            return scoreRepository.save(new Score(game, username));
        } else{
            throw new Exception("Only winning games can be on the scoreboard");
        }

    }

    ScoreService(ScoreRepository scoreRepository, GameRepository gameRepository){
        this.gameRepository = gameRepository;
        this.scoreRepository = scoreRepository;
    }
}
