package com.tank.config;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @author fuchun
 */
@Configuration
public class Initialization {

  @Bean
  public CommandLineRunner init() {
    return (args) -> {
      Preconditions.checkArgument(Objects.nonNull(this.restTemplate), "rest template not allowed empty");
      System.out.println("......init......");
    };
  }

  @Autowired
  private RestTemplate restTemplate;


  @Bean(name = "restTemplate")
  public RestTemplate createRestTemplate() {
    return new RestTemplate();
  }
}
