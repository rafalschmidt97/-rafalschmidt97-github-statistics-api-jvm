package com.rafalschmidt.github.web;

import com.rafalschmidt.github.application.HelloWorldHandler;
import lombok.val;

public class GithubStatisticsApplication {
  public static void main(String[] args) {
    val handler = new HelloWorldHandler();
    System.out.println(handler.handle("World"));
  }
}
