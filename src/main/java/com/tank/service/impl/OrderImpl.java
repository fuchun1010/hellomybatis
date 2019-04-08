package com.tank.service.impl;

import com.tank.constant.Result;
import com.tank.domain.Item;
import com.tank.domain.Order;
import com.tank.service.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;

/**
 * @author fuchun
 */
@Service
public class OrderImpl implements IOrder {

  @Override
  public Result saveOrder(@Nonnull Order order) {
    final String distributeCode = order.getDistributeCode();
    HashOperations<String, String, String> operations = this.redisTemplate.opsForHash();
    for (Item item : order.getItems()) {
      System.out.println(" apple = " + operations.get(distributeCode, item.getFruitCode()));
    }

    return Result.SUCCESS;
  }

  @Override
  public Long retrieveOrderId() {
    return this.redisTemplate.opsForValue().increment("orderId", 1);
  }


  @Autowired
  private RedisTemplate<String, String> redisTemplate;


}
