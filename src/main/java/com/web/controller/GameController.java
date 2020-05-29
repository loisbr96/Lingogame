package com.web.controller;

import com.persistence.GameRepository;
import com.persistence.model.Game;
import com.persistence.model.Word;
import com.services.GameService;
import com.services.WordService;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameRepository gameRepository;
    private final GameService gameService;
    private final WordService wordService;

    private static Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping("/new")
    public @ResponseBody Game newGame() throws Exception {
        return gameRepository.save(gameService.newGame());
    }

    @PostMapping("/run")
    public JSONObject runGame(@RequestBody int gameId, @RequestBody String tryWord) throws Exception {
        Word word = new Word(tryWord);
        Long id = (long) gameId;

        Optional<Game> gameOptional = gameRepository.findById(id);
        if (!gameOptional.isPresent()) {
            throw new Exception("Game not found");
        }
        Game game = gameOptional.get();
        gameService.runRound(game, word);
        return wordService.feedbackWord(game, word);
    }

    GameController(GameRepository gameRepository, GameService gameService, WordService wordService){
        this.gameRepository = gameRepository;
        this.gameService = gameService;
        this.wordService = wordService;
    }
}