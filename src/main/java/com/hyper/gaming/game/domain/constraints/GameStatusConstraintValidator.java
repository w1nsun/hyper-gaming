package com.hyper.gaming.game.domain.constraints;

import com.hyper.gaming.game.domain.enums.EGameStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GameStatusConstraintValidator
    implements ConstraintValidator<GameStatus, String> {
  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    if (s == null) {
      return true;
    }

    for (EGameStatus c : EGameStatus.values()) {
      if (c.name().equals(s.toUpperCase())) {
        return true;
      }
    }

    return false;
  }

  @Override
  public void initialize(GameStatus constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }
}
