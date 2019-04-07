package com.tank.domain;

import com.google.common.collect.Lists;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author fuchun
 * @date 2019-04-07
 */
@Data
public class Order {

  public void addItem(@Nonnull final Item item) {
    if (!items.contains(item)) {
      items.add(item);
    }
  }

  public void removeItem(@Nonnull final Item item) {
    if (items.contains(item)) {
      items.remove(item);
    }
  }


  public void removeItem(@Nonnull final String fruitCode) {
    int index = -1;
    for (int i = 0; i < this.items.size(); i++) {
      final Item tmp = this.items.get(i);
      if (tmp.getFruitCode().equalsIgnoreCase(fruitCode)) {
        index = i;
        break;
      }
    }
    if (index > -1) {
      this.items.remove(index);
    }

  }


  private String orderId;

  private String storeId;

  private String distributeCode;

  private List<Item> items = Lists.newLinkedList();
}
