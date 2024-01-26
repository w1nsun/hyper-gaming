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
@Constraint(validatedBy = GameStatusConstraintValidator.class)
public @interface GameStatus {
  String message() default "Invalid status";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
