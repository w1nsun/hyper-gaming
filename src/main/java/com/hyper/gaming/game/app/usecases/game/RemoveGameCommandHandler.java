package com.hyper.gaming.game.app.usecases.game;

import com.hyper.gaming.core.usecases.ICommandHandler;
import com.hyper.gaming.game.domain.models.Game;
import com.hyper.gaming.game.domain.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class RemoveGameCommandHandler implements ICommandHandler<RemoveGameCommand, Void> {
  private final GameRepository gameRepo;

  public RemoveGameCommandHandler(GameRepository gameRepo) {
    this.gameRepo = gameRepo;
  }

  @Override
  public Void execute(RemoveGameCommand command) {
    Game game = this.gameRepo.findById(command.id)
        .orElse(null);

    if (game == null) {
      throw new EntityNotFoundException();
    }

    this.gameRepo.delete(game);

    return null;
  }
}
