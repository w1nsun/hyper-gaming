package com.hyper.gaming.core.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Configuration
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    List<ErrorModel> errorModels = processErrors(ex);

    ErrorResponseModel responseBody =
        ErrorResponseModel.builder().errorModels(errorModels).type("VALIDATION").build();

    return new ResponseEntity<>(responseBody, headers, status);
  }

  private List<ErrorModel> processErrors(MethodArgumentNotValidException e) {
    List<ErrorModel> validationErrorModels = new ArrayList<>();
    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      ErrorModel validationErrorModel =
          ErrorModel.builder()
              .code(fieldError.getCode())
              .source(fieldError.getObjectName() + "/" + fieldError.getField())
              .detail(fieldError.getField() + " " + fieldError.getDefaultMessage())
              .build();
      validationErrorModels.add(validationErrorModel);
    }
    return validationErrorModels;
  }
}
