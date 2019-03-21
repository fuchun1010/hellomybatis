package com.tank.domain.tree;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

/**
 * @author fuchun
 */
public class Tree {

  public static Tree createInstance() {
    return Single.INSTANCE.fetchTreeInstance();
  }

  public Container toTree(final List<Item> nodes) {

    synchronized (root) {

      for (Item node : nodes) {
        if (root.isLeaf()) {
          root.add(node);
        } else {
          Item tmp = search(root, node);
          if (tmp == null) {
            root.add(node);
          } else {
            if (tmp instanceof Container) {
              ((Container) tmp).add(node);
            }

          }
        }
      }
    }

    return root;
  }


  public Container removeNode(final Node node) {

    synchronized (this.root) {
      this.removeNode(this.root, node);
    }

    return this.root;
  }

  public Container addNode(final Item node) {

    synchronized (this.root) {
      Item tmp = this.search(root, node);
      if (tmp != null) {
        if (tmp instanceof Container) {
          ((Container) tmp).add(node);
        }

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

  private Item removeNode(Container root, Node node) {

    synchronized (root) {
      for (Item tmp : root.getNodes()) {
        if (tmp.getId().equalsIgnoreCase(node.getId())) {
          root.getNodes().remove(node);
          return root;
        } else {
          if (tmp instanceof Container) {
            Item rs = this.removeNode((Container) tmp, node);
            if (rs != null) {
              return rs;
            }
          }

        }

      }
    }

    return root;
  }

  private Item search(final Container root, Item node) {

    synchronized (this.root) {
      for (Item tmp : root.getNodes()) {
        Preconditions.checkArgument(Objects.isNull(tmp.getId()), "id not allowed null");
        boolean isEqual = tmp.getId().equals(node.getPid());
        if (isEqual) {
          return tmp;
        } else {
          if (tmp instanceof Container) {
            Item rs = search((Container) tmp, node);
            if (Objects.nonNull(rs)) {
              return rs;
            }
          }

        }
      }

      return null;
    }


  }

  @Getter
  private Container root = new Container();

  private Tree() {

  }
}
