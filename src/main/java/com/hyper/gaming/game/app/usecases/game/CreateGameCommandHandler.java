package com.hyper.gaming.game.app.usecases.game;

import com.hyper.gaming.core.persistence.ULIDIdentity;
import com.hyper.gaming.core.usecases.ICommandHandler;
import com.hyper.gaming.game.domain.enums.GameType;
import com.hyper.gaming.game.domain.models.Game;
import com.hyper.gaming.game.domain.models.GameId;
import com.hyper.gaming.game.domain.repositories.GameRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateGameCommandHandler implements ICommandHandler<CreateGameCommand, Game> {
  private final GameRepository gameRepo;

  public CreateGameCommandHandler(GameRepository gameRepo) {
    this.gameRepo = gameRepo;
  }

  @Override
  public Game execute(CreateGameCommand command) {
    Game game = new Game(ULIDIdentity.generate(GameId.class));
    game
        .setName(command.name)
        .setType(GameType.SLOT);

    return this.gameRepo.save(game);
  }
}
