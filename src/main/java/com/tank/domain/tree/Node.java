package com.tank.domain.tree;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

public class Node {

  @Getter
  @Setter
  private String id = "";

  @Getter
  @Setter
  private String pid = "";

  @Getter
  @Setter
  private String tagId = "";

  @Getter
  @Setter
  private int count = 0;

  @Getter
  @Setter
  private String desc = "";

  @Getter
  private List<Node> nodes = Lists.newLinkedList();


  public boolean isLeaf() {
    return nodes.size() == 0;
  }

  public void add(final Node node) {
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
    return Objects.equals(tagId, node.tagId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagId);
  }
}
