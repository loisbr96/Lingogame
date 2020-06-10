package com.services;

import com.persistence.GameRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final WordService wordService;

    private static Logger logger = LoggerFactory.getLogger(GameService.class);

    GameService(GameRepository gameRepository, WordService wordService){
        this.gameRepository = gameRepository;
        this.wordService = wordService;
    }

    public Game newGame() throws Exception {
        Game game = new Game();
        game.setWord(wordService.getRandomWord());
        return game;
    }

    public boolean runRound(Game game, Word tryWord){
        String userWord = tryWord.getWord();
        String gameWord = game.getWord().getWord();
        if(gameWord.length() != userWord.length()){
            logger.info(String.format("The word has %s letters", gameWord.length()));
            game.setRound(game.getRound() +1);
            return false;
        }
        if(game.hadEnded()){
            logger.error("ENDED! The game has already ended.");
            return false;
        }else if(userWord.equals(game.getWord().getWord())){
            game.won();
            game.setRound(game.getRound());
            game.setScore(120 - 20 * game.getRound() );
            gameRepository.save(game);
            logger.info("WON!! The state of the game is changed into WON");
            return true;
        }else if(!userWord.equals(gameWord) && game.getRound() >= 5){
            game.lost();
            gameRepository.save(game);
            logger.error("LOST!! The state of the game is changed into LOST");
            return false;
        }else {
            game.setRound(game.getRound() + 1);
            gameRepository.save(game);
        }
        return tryWord.equals(game.getWord());
    }
}
