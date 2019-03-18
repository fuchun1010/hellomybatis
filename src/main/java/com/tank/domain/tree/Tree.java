package com.tank.domain.tree;

import java.util.List;
import java.util.Objects;

/**
 * @author fuchun
 */
public class Tree {

  public static Tree createInstance() {
    return Single.INSTANCE.fetchTreeInstance();
  }

  public Node toTree(final List<Node> nodes) {

    synchronized (root) {

      for (Node node : nodes) {
        if (root.isLeaf()) {
          root.add(node);
        } else {
          Node tmp = search(root, node);
          if (tmp == null) {
            root.add(node);
          } else {
            tmp.add(node);
          }
        }
      }
    }

    return root;
  }

  public Node removeNode(final Node node) {

    synchronized (this.root) {
      this.removeNode(this.root, node);
    }

    return this.root;
  }

  public Node addNode(final Node node) {

    synchronized (this.root) {
      Node tmp = this.search(root, node);
      if (tmp != null) {
        tmp.add(node);
      } else {
        root.add(node);
      }
    }

    return this.root;
  }

  enum Single {
    INSTANCE;

    Single() {
      this.tree = new Tree();
    }

    public Tree fetchTreeInstance() {
      return this.tree;
    }

    private Tree tree;
  }

  private Node removeNode(Node root, Node node) {

    synchronized (root) {
      for (Node tmp : root.getNodes()) {
        if (tmp.getId().equalsIgnoreCase(node.getId())) {
          root.getNodes().remove(node);
          return root;
        } else {
          Node rs = this.removeNode(tmp, node);
          if (rs != null) {
            return rs;
          }
        }

      }
    }

    return root;
  }

  private Node search(final Node root, Node node) {

    synchronized (this.root) {
      for (Node tmp : root.getNodes()) {
        boolean isEqual = tmp.getId().equals(node.getPid());
        if (isEqual) {
          return tmp;
        } else {
          Node rs = search(tmp, node);
          if (Objects.nonNull(rs)) {
            return rs;
          }
        }
      }

      return null;
    }


  }

  private Node root = new Node();

  private Tree() {

  }
}
