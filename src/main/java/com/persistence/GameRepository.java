package com.persistence;

import com.persistence.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    Game findById(Game id);
}
