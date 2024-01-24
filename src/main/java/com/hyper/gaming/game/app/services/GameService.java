package com.hyper.gaming.game.app.services;

import com.hyper.gaming.game.app.usecases.game.CreateGameCommand;
import com.hyper.gaming.game.app.usecases.game.CreateGameCommandHandler;
import com.hyper.gaming.game.app.usecases.game.UpdateGameCommand;
import com.hyper.gaming.game.app.usecases.game.UpdateGameCommandHandler;
import com.hyper.gaming.game.domain.models.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
  private final CreateGameCommandHandler createGameCommandHandler;
  private final UpdateGameCommandHandler updateGameCommandHandler;

  public GameService(CreateGameCommandHandler createGameCommandHandler, UpdateGameCommandHandler updateGameCommandHandler) {
    this.createGameCommandHandler = createGameCommandHandler;
    this.updateGameCommandHandler = updateGameCommandHandler;
  }

  public Game create(CreateGameCommand command) {
    return this.createGameCommandHandler.execute(command);
  }

  public Game update(UpdateGameCommand command) {
    return this.updateGameCommandHandler.execute(command);
  }
}
