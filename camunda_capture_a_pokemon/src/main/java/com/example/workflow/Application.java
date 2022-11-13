package com.example.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//  http://localhost:8081/camunda/app/welcome/default/#!/login
//  https://codedevstuff.blogspot.com/2015/05/change-port-on-spring-boot-application.html
  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}