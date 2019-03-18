package com.tank.domain.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * @author fuchun
 */
public class Container extends Item {

  @Getter
  private List<Item> nodes = Lists.newLinkedList();

  @JsonIgnore
  public boolean isLeaf() {
    return nodes.size() == 0;
  }

  public void add(final Item node) {
    nodes.add(node);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Node node = (Node) obj;
    return Objects.equals(this.getId(), node.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId());
  }

  @Getter
  @Setter
  private String name;
}
