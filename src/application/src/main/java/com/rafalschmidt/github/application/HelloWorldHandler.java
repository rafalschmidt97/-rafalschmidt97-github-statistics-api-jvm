package com.rafalschmidt.github.application;

import lombok.val;

public class HelloWorldHandler {
  public String handle(String name) {
    val messageFormat = "Hello %s";
    return String.format(messageFormat, name);
  }
}
