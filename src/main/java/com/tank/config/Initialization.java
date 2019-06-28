package com.tank.config;

import com.google.common.base.Preconditions;
import com.tank.domain.mapper.RecordRes;
import com.tank.domain.tree.Container;
import com.tank.domain.tree.Item;
import com.tank.domain.tree.Node;
import com.tank.domain.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author fuchun
 */
@Configuration
public class Initialization {

  @Value("${tagService.url}")
  private String url;
  @Autowired
  private RestTemplate restTemplate;
  private Tree tree = Tree.createInstance();

  @Bean
  public CommandLineRunner init() {
    return (args) -> {
      List<Item> items = this.convert2Item();
      boolean isExists = Objects.nonNull(items) && items.size() > 0;
      if (isExists) {
        Container rs = tree.toTree(items);
        boolean isOk = rs.getNodes().size() > 0;
        if (isOk) {
          System.out.println("...init tree ok ....");
        }
      }
    };
  }

  @Bean(name = "restTemplate")
  public RestTemplate createRestTemplate() {
    return new RestTemplate();
  }

  private List<Item> convert2Item() {
    Preconditions.checkArgument(Objects.nonNull(this.restTemplate), "rest template not allowed empty");
    RecordRes recordRes = this.restTemplate.getForObject(this.url, RecordRes.class);
    List<Item> items = recordRes.getRecords().stream().map(record -> {
      boolean isDir = Objects.isNull(record.getTagId());
      String id = record.getId();
      String pid = record.getPid();
      String name = record.getName();
      if (isDir) {
        Container container = new Container();
        container.setPid(pid);
        container.setId(id);
        container.setName(name);
        return container;
      } else {
        Node node = new Node();
        node.setPid(pid);
        node.setId(id);
        node.setTagId(record.getTagId());
        node.setName(name);
        node.setIsEnable(record.getIsEnable());
        return node;
      }
    }).collect(Collectors.toList());
    return items;
  }
}
