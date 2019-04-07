package com.tank.service.impl;

import com.tank.constant.Result;
import com.tank.domain.Order;
import com.tank.service.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Resource;

@Service
public class OrderImpl implements IOrder {

  @Override
  public Result saveOrder(@Nonnull Order order) {
    
    return Result.FAILURE;
  }


  @Autowired
  private RedisTemplate<String, String> template;


  @Resource(name = "redisTemplate")
  private HashOperations<String, String, String> hashOperations;

}
