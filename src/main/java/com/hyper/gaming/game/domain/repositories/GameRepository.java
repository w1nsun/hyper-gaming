package com.hyper.gaming.game.domain.repositories;

import com.hyper.gaming.game.domain.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, String> {
}
