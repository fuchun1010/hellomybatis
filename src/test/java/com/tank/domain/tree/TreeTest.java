package com.tank.domain.tree;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TreeTest {

  @Before
  public void init() {
    this.tree = Tree.createInstance();
    this.nodes = Lists.newLinkedList();
    Node nodeA = new Node();
    nodeA.setId("1");
    nodeA.setPid("0");
    nodeA.setDesc("目录1");

    Node nodeB = new Node();
    nodeB.setId("2");
    nodeB.setPid("1");
    nodeB.setCount(50);
    nodeB.setDesc("标签1");

    Node nodeC = new Node();
    nodeC.setId("3");
    nodeC.setPid("2");
    nodeC.setCount(120);
    nodeC.setDesc("标签2");

    Node nodeD = new Node();
    nodeD.setId("4");
    nodeD.setPid("0");
    nodeD.setCount(130);
    nodeD.setDesc("标签3");

    this.nodes.add(nodeA);
    this.nodes.add(nodeB);
    this.nodes.add(nodeC);
    this.nodes.add(nodeD);

    //初始化root
    this.root = this.tree.toTree(this.nodes);
  }

  @Test
  public void toTree() {

    Assert.assertTrue(this.root.getNodes().size() == 2);
  }

  @Test
  public void removeNode() {
    Node nodeC = new Node();
    nodeC.setId("3");
    nodeC.setPid("2");
    nodeC.setCount(120);
    nodeC.setDesc("标签2");
    Node root = this.tree.removeNode(nodeC);
    List<Node> nodes = root.getNodes();
    Node node = nodes.get(0);
    Assert.assertTrue(node.getNodes().size() == 0);
  }

  @Test
  public void addNode() {
    Node nodeE = new Node();
    nodeE.setId("3");
    nodeE.setPid("0");
    nodeE.setCount(120);
    nodeE.setDesc("目录x");
    this.nodes.add(nodeE);
    Node node = this.tree.addNode(nodeE);
    Assert.assertTrue(node.getNodes().size() == 3);
    Assert.assertTrue(node.getNodes().size() == 3);
  }

  private Tree tree;

  private List<Node> nodes;

  private Node root;
}