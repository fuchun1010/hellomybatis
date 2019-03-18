package com.tank;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fuchun
 */
@SpringBootApplication
@MapperScan(basePackages = "com.tank.mapper")
public class HelloMyBatis {
  public static void main(String[] args) {
    SpringApplication.run(HelloMyBatis.class);
  }
}
