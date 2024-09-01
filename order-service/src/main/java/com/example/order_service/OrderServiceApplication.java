package com.example.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class OrderServiceApplication {
  @Autowired
  Environment env;

	public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

  @GetMapping("/status")
  public String status() {
  return "Status - returned by Pod - " + env.getProperty("HOSTNAME")  ; 
  //HOSTNAME => POD name serving request
 }
}
