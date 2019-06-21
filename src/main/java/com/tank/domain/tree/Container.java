package com.tank.domain.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

/**
 * @author fuchun
 */
public class Container extends Item {

  @Getter
  private List<Item> nodes = Lists.newLinkedList();

  public void add(final Item node) {
    nodes.add(node);
  }


  @JsonIgnore
  public boolean isLeaf() {
    return this.nodes.size() == 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Item node = (Item) obj;
    return Objects.equals(this.getId(), node.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId());
  }


}
