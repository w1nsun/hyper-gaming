package com.hyper.gaming.game.domain.models;

import com.hyper.gaming.game.domain.enums.EGameStatus;
import com.hyper.gaming.game.domain.enums.EGameType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
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

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "game")
  private Set<GameBet> bets = new HashSet<>();

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private EGameStatus status;

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
    this.status = EGameStatus.ACTIVE;
  }

  public Game setName(String name) {
    this.name = name;

    return this;
  }

  public Game setType(EGameType type) {
    this.type = type;

    return this;
  }

  public Game addBet(BigDecimal amount) {
    GameBet bet = new GameBet(UUID.randomUUID());
    bet.setGame(this);
    bet.setAmount(amount);

    this.bets.add(bet);

    return this;
  }

  public EGameStatus getStatus() {
    return status;
  }

  public Game setStatus(EGameStatus status) {
    this.status = status;

    return this;
  }
}
