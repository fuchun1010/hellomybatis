package com.tank.domain.tree;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tank.deseria.ItemDeserializer;
import lombok.Data;

import java.util.Objects;

@Data
@JsonDeserialize(using = ItemDeserializer.class)
public abstract class Item {

  private String id;

  private String pid = null;

  private String name;


  @Override
  public boolean equals(final Object object) {

    boolean isItem = object instanceof Item;

    if (!isItem) {
      return false;
    }

    Item tmp = (Item) object;

    return tmp.getId().equalsIgnoreCase(tmp.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.getId());
  }


}
