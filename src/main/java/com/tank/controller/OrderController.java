package com.tank.controller;

import com.google.common.collect.Maps;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author fuchun
 */
@Controller
@RequestMapping("/v1/order")
public class OrderController {

  @GetMapping("/hello")
  public ResponseEntity<Map<String, String>> hello() {
    val map = Maps.<String, String>newHashMap();
    map.put("hello", "hello,redis");
    return ResponseEntity.ok(map);
  }


}