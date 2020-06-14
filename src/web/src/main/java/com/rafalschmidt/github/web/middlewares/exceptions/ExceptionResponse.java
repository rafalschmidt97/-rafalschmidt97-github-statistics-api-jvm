package com.rafalschmidt.github.web.middlewares.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
  private String type;
  private String message;
}
