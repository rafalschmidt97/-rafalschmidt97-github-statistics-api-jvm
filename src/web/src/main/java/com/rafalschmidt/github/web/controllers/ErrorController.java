package com.rafalschmidt.github.web.controllers;

import com.rafalschmidt.github.web.middlewares.exceptions.ExceptionResponse;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("error")
@Api(tags = "Error")
public class ErrorController {

  @GetMapping()
  public ResponseEntity<ExceptionResponse> error() {
    return new ResponseEntity<>(
      new ExceptionResponse(
        HttpStatus.NOT_FOUND.name(),
        "Endpoint does not exist."
      ),
      HttpStatus.NOT_FOUND
    );
  }
}
