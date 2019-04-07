package com.tank.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

  @Test
  public void addITem() {
    Assert.assertTrue(this.order.getItems().size() == 1);
    Item item = new Item();
    item.setFruitCode("a0001");
    item.setQuantity(300);
    this.order.addItem(item);
    Assert.assertTrue(this.order.getItems().size() == 1);
  }

  @Test
  public void removeItem() {
    Item item = new Item();
    item.setFruitCode("a0001");
    item.setQuantity(300);
    this.order.removeItem(item);
    Assert.assertTrue(this.order.getItems().size() == 0);
  }

  @Test
  public void removeItemWithFruitCode() {
    this.order.removeItem("a0001");
    Assert.assertTrue(this.order.getItems().size() == 0);
  }

  @Before
  public void init() {
    this.order = new Order();
    Item item = new Item();
    item.setFruitCode("a0001");
    item.setQuantity(300);
    order.addItem(item);
  }

  private Order order;
}