package com.tank.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.tank.domain.tree.Container;
import com.tank.domain.tree.Item;
import com.tank.domain.tree.Tree;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/v1")
public class TreeController {

  @PostMapping(path = "/tree/created")
  public ResponseEntity<Map<String, Object>> createTree(@RequestBody final Map<String, List<Item>> body) {
    final List<Item> nodes = body.get("body");
    synchronized (this.root) {
      root = tree.toTree(nodes);
    }
    final Map<String, Object> response = Maps.newHashMap();
    response.put("root", root.getNodes());
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/tree")
  public ResponseEntity<Map<String, List<Item>>> fetchTree() {
    synchronized (this.root) {
      root = this.tree.getRoot();
    }
    Map<String, List<Item>> tree = Maps.newHashMap();
    tree.put("root", root.getNodes());
    return ResponseEntity.ok(tree);
  }

  @PostMapping(path = "/add/node")
  public ResponseEntity<Map<String, List<Item>>> addNode(@RequestBody final Item item) {
    Preconditions.checkArgument(Objects.nonNull(item), "item not allowed empty");
    synchronized (this.root) {
      this.root = this.tree.addNode(item);
    }
    Map<String, List<Item>> tree = Maps.newHashMap();
    tree.put("root", root.getNodes());
    return ResponseEntity.ok(tree);
  }

  @DeleteMapping(path = "/delete/{id}/node")
  public ResponseEntity removeNode(@PathVariable("id") final String id) {
    synchronized (this.root) {
      this.root = this.tree.removeNode(id);
    }
    return ResponseEntity.ok().build();
  }


  private Tree tree = Tree.createInstance();

  private Container root = new Container();

}
