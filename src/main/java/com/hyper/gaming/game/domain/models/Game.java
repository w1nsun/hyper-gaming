package com.hyper.gaming.game.domain.models;

import com.hyper.gaming.game.domain.enums.EGameType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "Game")
@Table(name = "game_games")
public class Game {
  @Id
  private UUID id;

  @Column(nullable = false, length = 64)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EGameType type;

  @CreationTimestamp
  @Column
  private Instant updatedAt;

  @UpdateTimestamp
  @Column
  private Instant createdAt;

  public Game() {
  }

  public Game(UUID id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Game{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", type=" + type +
        ", updatedAt=" + updatedAt +
        ", createdAt=" + createdAt +
        '}';
  }

  public Game setName(String name) {
    this.name = name;

    return this;
  }

  public Game setType(EGameType type) {
    this.type = type;

    return this;
  }
}
