package com.tank.service;

import com.tank.constant.Result;
import com.tank.domain.Order;

import javax.annotation.Nonnull;

/**
 * @author fuchun
 * @date 2019-04-07
 */
public interface IOrder {

  Result saveOrder(@Nonnull final Order order);

  Long retrieveOrderId();

}
