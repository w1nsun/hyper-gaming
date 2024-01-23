package com.hyper.gaming.game.domain.models;

import com.hyper.gaming.game.domain.enums.GameType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity(name = "Game")
@Table(name = "game_games")
public class Game {
  @Id
  @Column(name = "id", length = 26, nullable = false)
  private GameId id;

  @Column(nullable = false, length = 64)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private GameType type;

  @CreationTimestamp
  @Column
  private Instant updatedAt;

  @UpdateTimestamp
  @Column
  private Instant createdAt;

  public Game() {
  }

  public Game(GameId id) {
    this.id = id;
  }

  public Game setName(String name) {
    this.name = name;

    return this;
  }

  public Game setType(GameType type) {
    this.type = type;

    return this;
  }
}
