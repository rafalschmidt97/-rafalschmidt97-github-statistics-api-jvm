package com.rafalschmidt.github.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CustomHttpException extends RuntimeException {
  @Getter
  private final HttpStatus status;

  public CustomHttpException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }

  public CustomHttpException(HttpStatus status, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
  }
}
