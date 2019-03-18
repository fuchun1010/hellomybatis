package com.tank.mapper;

import com.google.common.base.Preconditions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

  @Test
  public void testQueryAll() {

    Preconditions.checkArgument(Objects.nonNull(this.orderMapper), "order mapper not allowed empty");
    int num = this.orderMapper.queryAll().size();
    Assert.assertTrue(num > 0);
  }

  @Autowired(required = true)
  private OrderMapper orderMapper;
}