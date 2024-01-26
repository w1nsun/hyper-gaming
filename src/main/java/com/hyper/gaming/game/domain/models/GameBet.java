package com.hyper.gaming.game.domain.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "GameBet")
@Table(name = "game_bets")
public class GameBet {
  @Id
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "game_id", nullable = false)
  private Game game;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal amount;

  public GameBet() {
  }

  public GameBet(UUID id) {
    this.id = id;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public void setAmount(BigDecimal bet) {
    this.amount = bet;
  }
}
