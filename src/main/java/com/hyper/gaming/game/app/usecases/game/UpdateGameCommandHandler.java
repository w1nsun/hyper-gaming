package com.hyper.gaming.game.app.usecases.game;

import com.hyper.gaming.core.usecases.ICommandHandler;
import com.hyper.gaming.game.domain.enums.EGameType;
import com.hyper.gaming.game.domain.models.Game;
import com.hyper.gaming.game.domain.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UpdateGameCommandHandler implements ICommandHandler<UpdateGameCommand, Game> {
  private final GameRepository gameRepo;

  public UpdateGameCommandHandler(GameRepository gameRepo) {
    this.gameRepo = gameRepo;
  }

  @Override
  public Game execute(UpdateGameCommand command) {
    Game game = this.gameRepo.findById(command.id).orElse(null);

    if (game == null) {
      throw new EntityNotFoundException();
    }

    game
        .setName(command.name)
        .setType(EGameType.valueOf(command.type));

    return this.gameRepo.save(game);
  }
}
