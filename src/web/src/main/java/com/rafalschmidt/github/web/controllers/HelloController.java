package com.rafalschmidt.github.web.controllers;

import com.rafalschmidt.github.application.HelloOperations;
import com.rafalschmidt.github.application.HelloWorldHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@RequiredArgsConstructor
public class HelloController implements HelloOperations {
  private final HelloWorldHandler helloWorldHandler;

  @GetMapping("{name}")
  @Override
  public String hello(@PathVariable String name) {
    return helloWorldHandler.handle(name);
  }
}
