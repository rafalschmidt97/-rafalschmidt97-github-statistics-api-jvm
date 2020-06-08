package com.rafalschmidt.github.web.controllers;

import com.rafalschmidt.github.application.HelloOperations;
import com.rafalschmidt.github.application.HelloWorldHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController implements HelloOperations {

  @Override
  @GetMapping("{name}")
  public String hello(@PathVariable String name) {
    return new HelloWorldHandler().handle(name);
  }
}
