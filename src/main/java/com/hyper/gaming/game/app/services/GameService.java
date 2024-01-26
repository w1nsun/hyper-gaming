package com.hyper.gaming.game.app.services;

import com.hyper.gaming.game.app.usecases.game.*;
import com.hyper.gaming.game.domain.models.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
  private final CreateGameCommandHandler createGameCommandHandler;
  private final UpdateGameCommandHandler updateGameCommandHandler;
  private final RemoveGameCommandHandler removeGameCommandHandler;

  public GameService(
      CreateGameCommandHandler createGameCommandHandler,
      UpdateGameCommandHandler updateGameCommandHandler,
      RemoveGameCommandHandler removeGameCommandHandler
  ) {
    this.createGameCommandHandler = createGameCommandHandler;
    this.updateGameCommandHandler = updateGameCommandHandler;
    this.removeGameCommandHandler = removeGameCommandHandler;
  }

  public Game create(CreateGameCommand command) {
    return this.createGameCommandHandler.execute(command);
  }

  public Game update(UpdateGameCommand command) {
    return this.updateGameCommandHandler.execute(command);
  }

  public void remove(RemoveGameCommand command) {
    this.removeGameCommandHandler.execute(command);
  }
}
