package com.hyper.gaming.game.ui.controllers;

import com.hyper.gaming.game.app.services.GameService;
import com.hyper.gaming.game.app.usecases.game.CreateGameCommand;
import com.hyper.gaming.game.domain.models.Game;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
public class GameController {
  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Game> create(@Valid @RequestBody CreateGameCommand command) {
    Game game = this.gameService.create(command);

    return ResponseEntity.status(HttpStatus.CREATED).body(game);
  }
}
