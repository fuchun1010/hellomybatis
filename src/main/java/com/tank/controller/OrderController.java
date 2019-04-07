package com.tank.controller;

import com.google.common.collect.Maps;
import com.tank.constant.Result;
import com.tank.domain.Order;
import com.tank.service.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author fuchun
 */
@Controller
@RequestMapping("/v1/order")
public class OrderController {


  @PostMapping("/save")
  public ResponseEntity<Map<String, String>> save(@RequestBody final Order order) {
    boolean isEmptyItems = order.getItems().size() == 0;
    Map<String, String> response = Maps.newHashMap();
    if (isEmptyItems) {
      throw new IllegalArgumentException("items not allowed empty");
    }

    long orderId = this.orderService.retrieveOrderId();
    order.setOrderId(orderId);
    order.setDistributeCode("dis:0001");
    Result result = this.orderService.saveOrder(order);

    if (result == Result.SUCCESS) {
      response.put("orderId", "" + orderId);
      return ResponseEntity.ok(response);
    } else {
      response.put("msg", "some error in server");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }


  }


  @Autowired
  private IOrder orderService;

}
