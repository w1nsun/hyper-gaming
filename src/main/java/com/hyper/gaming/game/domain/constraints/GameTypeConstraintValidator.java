package com.hyper.gaming.game.domain.constraints;

import com.hyper.gaming.game.domain.enums.EGameType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GameTypeConstraintValidator
    implements ConstraintValidator<GameType, String> {
  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    if (s == null) {
      return true;
    }

    for (EGameType c : EGameType.values()) {
      if (c.name().equals(s.toUpperCase())) {
        return true;
      }
    }

    return false;
  }

  @Override
  public void initialize(GameType constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }
}
