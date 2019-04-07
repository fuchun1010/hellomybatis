package com.tank.domain;

import lombok.Data;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * @author fuchun
 */
@Data
public class Item {

  @Override
  public boolean equals(@Nonnull Object obj) {

    boolean isItem = obj instanceof Item;

    if (!isItem) {
      return false;
    }

    Item target = ((Item) obj);

    return target.getFruitCode().equalsIgnoreCase(this.getFruitCode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(fruitCode, quantity);
  }

  private String fruitCode;

  private double quantity;
}
