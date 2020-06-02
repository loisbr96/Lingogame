package com.web.controller;

import com.persistence.ScoreRepository;
import com.persistence.model.Score;
import com.services.ScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreRepository scoreRepository;
    private final ScoreService scoreService;

    @GetMapping("")
    public @ResponseBody Iterable<Score> scores(){
        return scoreRepository.findAll();
    }

    @PostMapping("/new")
    @ResponseBody
    public Score add(@RequestParam(name = "gameId") long gameId, @RequestParam(name = "username") String username) throws Exception{
        return scoreService.addScore(gameId, username);
    }

    ScoreController(ScoreRepository scoreRepository, ScoreService scoreService){
        this.scoreRepository = scoreRepository;
        this.scoreService = scoreService;
    }
}
