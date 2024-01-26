package com.hyper.gaming.game.app.usecases.game;

import com.hyper.gaming.core.usecases.ICommandHandler;
import com.hyper.gaming.game.domain.enums.EGameStatus;
import com.hyper.gaming.game.domain.enums.EGameType;
import com.hyper.gaming.game.domain.models.Game;
import com.hyper.gaming.game.domain.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

    if (command.status != null) {
      game.setStatus(EGameStatus.valueOf(command.status));
    }

    for (BigDecimal betAmount: command.bets) {
      game.addBet(betAmount);
    }

    return this.gameRepo.save(game);
  }
}
