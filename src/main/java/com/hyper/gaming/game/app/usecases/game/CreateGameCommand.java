package com.hyper.gaming.game.app.usecases.game;

import com.hyper.gaming.core.usecases.ICommand;
import com.hyper.gaming.game.domain.constraints.GameType;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public class CreateGameCommand implements ICommand {
  @NotBlank
  @Size(max = 64)
  public String name;

  @NotBlank
  @GameType(message = "Invalid type of the game")
  public String type;

  @NotEmpty
  @Size(min = 1, max = 10)
  public List<@DecimalMin("0.01") @DecimalMax("10000.00") BigDecimal> bets;
}
