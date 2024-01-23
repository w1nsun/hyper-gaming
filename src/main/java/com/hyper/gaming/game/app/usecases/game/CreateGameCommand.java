package com.hyper.gaming.game.app.usecases.game;

import com.hyper.gaming.core.usecases.ICommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateGameCommand implements ICommand {
  @NotBlank
  @Size(max = 64)
  public String name;
}
