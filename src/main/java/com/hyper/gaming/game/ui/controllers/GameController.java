package com.hyper.gaming.game.ui.controllers;

import com.hyper.gaming.game.app.services.GameService;
import com.hyper.gaming.game.app.usecases.game.CreateGameCommand;
import com.hyper.gaming.game.app.usecases.game.RemoveGameCommand;
import com.hyper.gaming.game.app.usecases.game.UpdateGameCommand;
import com.hyper.gaming.game.domain.models.Game;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class GameController {
  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Game> create(@Valid
                                     @RequestBody
                                     CreateGameCommand command) {
    Game game = this.gameService.create(command);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(game);
  }

  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
  public ResponseEntity<Game> update(@Valid
                                     @RequestBody
                                     UpdateGameCommand command,
                                     @PathVariable
                                     @NotNull
                                     @UUID
                                     String id
  ) {
    command.id = java.util.UUID.fromString(id);
    Game game = this.gameService.update(command);

    return ResponseEntity.status(HttpStatus.OK)
        .body(game);
  }

  @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
  public ResponseEntity<String> remove(
      @PathVariable
      @NotNull
      @UUID
      String id
  ) {
    RemoveGameCommand command = new RemoveGameCommand();
    command.id = java.util.UUID.fromString(id);
    this.gameService.remove(command);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("OK");
  }
}
