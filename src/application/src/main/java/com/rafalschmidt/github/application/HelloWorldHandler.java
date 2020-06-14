package com.rafalschmidt.github.application;

import lombok.val;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldHandler {
  public String handle(String name) {
    val messageFormat = "Hello %s";
    return String.format(messageFormat, name);
  }
}
