package com.hyper.gaming.game.domain.models;

import com.hyper.gaming.core.persistence.ULIDIdentity;

public class GameId  extends ULIDIdentity {
  public GameId(String ulid) {
    super(ulid);
  }
}
