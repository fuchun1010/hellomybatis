package com.tank.controller;

import com.google.common.collect.Maps;
import com.tank.domain.Order;
import com.tank.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author fuchun
 */
@Controller
@RequestMapping("/v1/order")
public class OrderController {

  @GetMapping(path = "/list")
  public ResponseEntity<Map<String, List<Order>>> list() {
    final List<Order> orders = this.orderMapper.queryAll();
    final Map<String, List<Order>> response = Maps.newHashMap();
    response.put("orders", orders);
    return ResponseEntity.ok(response);
  }

  @Autowired
  private OrderMapper orderMapper;
}
