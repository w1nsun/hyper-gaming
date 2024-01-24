package com.hyper.gaming.game.domain.repositories;

import com.hyper.gaming.game.domain.models.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GameRepository extends CrudRepository<Game, UUID> {
}
