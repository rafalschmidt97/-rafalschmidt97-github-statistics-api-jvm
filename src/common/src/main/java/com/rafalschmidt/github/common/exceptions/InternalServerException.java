package com.rafalschmidt.github.common.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerException extends CustomHttpException {
  public InternalServerException(String message, Throwable cause) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, message, cause);
  }

  public InternalServerException(String message) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, message);
  }

  public InternalServerException(Throwable cause) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), cause);
  }

  public InternalServerException() {
    super(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
  }
}
