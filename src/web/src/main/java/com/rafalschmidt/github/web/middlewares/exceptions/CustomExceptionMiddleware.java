package com.rafalschmidt.github.web.middlewares.exceptions;

import com.rafalschmidt.github.common.exceptions.CustomHttpException;
import com.rafalschmidt.github.common.exceptions.InternalServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.google.common.base.Predicates.instanceOf;
import static io.vavr.API.*;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class CustomExceptionMiddleware {

  @ExceptionHandler(CustomHttpException.class)
  public ResponseEntity<ExceptionResponse> handleCustomException(CustomHttpException exception) {

    Match((Object) exception).of(
      Case($(instanceOf(InternalServerException.class)), run(() -> {
        log.error(exception.getStatus().getReasonPhrase());
        exception.printStackTrace();
      }))
    );

    if (exception instanceof InternalServerException) {
      log.error(exception.getStatus().getReasonPhrase());
      exception.printStackTrace();
    }

    return new ResponseEntity<>(
      new ExceptionResponse(
        exception.getStatus().name(),
        exception.getMessage()
      ),
      exception.getStatus()
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handleUnknownException(Exception exception) {
    log.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    exception.printStackTrace();

    return new ResponseEntity<>(
      new ExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.name(),
        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
      ),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
