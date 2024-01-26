package com.hyper.gaming.game.app.usecases.game;

import com.hyper.gaming.core.usecases.ICommandHandler;
import com.hyper.gaming.game.domain.enums.EGameStatus;
import com.hyper.gaming.game.domain.enums.EGameType;
import com.hyper.gaming.game.domain.models.Game;
import com.hyper.gaming.game.domain.repositories.GameRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CreateGameCommandHandler implements ICommandHandler<CreateGameCommand, Game> {
  private final GameRepository gameRepo;

  public CreateGameCommandHandler(GameRepository gameRepo) {
    this.gameRepo = gameRepo;
  }

  @Override
  public Game execute(CreateGameCommand command) {
    Game game = new Game(UUID.randomUUID());
    game
        .setName(command.name)
        .setType(EGameType.valueOf(command.type))
        .setStatus(command.status != null ? EGameStatus.valueOf(command.status) : EGameStatus.ACTIVE);

    for (BigDecimal betAmount: command.bets) {
      game.addBet(betAmount);
    }

    return this.gameRepo.save(game);
  }
}
