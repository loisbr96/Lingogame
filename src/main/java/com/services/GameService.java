package com.services;

import com.persistence.GameRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;
import org.springframework.stereotype.Service;


@Service
public class GameService {
    private final GameRepository gameRepository;
    private final WordService wordService;

    public Game newGame() throws Exception {
        Game game = new Game();
        game.setWord(wordService.getRandomWord());
        return game;
    }

    public boolean runRound(Game game, Word tryWord) throws Exception {
        String userWord = tryWord.getWord();
        String gameWord = game.getWord().getWord();
        if(gameWord.length() != userWord.length()){
            throw new Exception("The word has " + gameWord.length() + " letters. Try again");
        }
        if(game.hadEnded()){
            throw new Exception("The game has ended");
        }else if(userWord.equals(game.getWord().getWord())){
            game.won();
            game.setRound(game.getRound());
            game.setScore(120 - 20 * game.getRound() );
            gameRepository.save(game);
            throw new Exception("You have won the game");
        }else if(!userWord.equals(gameWord) && game.getRound() >= 5){
            game.lost();
            gameRepository.save(game);
            throw new Exception("You have lost the game");
        }else {
            game.setRound(game.getRound() + 1);
            gameRepository.save(game);
        }
        return tryWord.equals(game.getWord());
    }

    GameService(GameRepository gameRepository, WordService wordService){
        this.gameRepository = gameRepository;
        this.wordService = wordService;
    }



}
