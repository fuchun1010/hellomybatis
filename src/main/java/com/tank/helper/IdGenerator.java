package com.tank.helper;

import com.tank.service.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fuchun
 */
@Component
public class IdGenerator {


  public String generateOrderId() {
    final String id = String.valueOf(orderService.retrieveOrderId());
    StringBuffer sb = new StringBuffer();
    sb.append(id);
    return sb.toString();
  }

  @Autowired
  private IOrder orderService;
}
