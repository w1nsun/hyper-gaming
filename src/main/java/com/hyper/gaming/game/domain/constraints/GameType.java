package com.hyper.gaming.game.domain.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({
  ElementType.METHOD,
  ElementType.FIELD,
  ElementType.ANNOTATION_TYPE,
  ElementType.CONSTRUCTOR,
  ElementType.PARAMETER,
  ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = GameTypeConstraintValidator.class)
public @interface GameType {
  String message() default "Invalid type";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
