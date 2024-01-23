package com.hyper.gaming.game.app.services;

import com.hyper.gaming.game.app.usecases.game.CreateGameCommand;
import com.hyper.gaming.game.app.usecases.game.CreateGameCommandHandler;
import com.hyper.gaming.game.domain.models.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
  private final CreateGameCommandHandler createGameCommandHandler;

  public GameService(CreateGameCommandHandler createGameCommandHandler) {
    this.createGameCommandHandler = createGameCommandHandler;
  }

  public Game create(CreateGameCommand command) {
    return this.createGameCommandHandler.execute(command);
  }
}
