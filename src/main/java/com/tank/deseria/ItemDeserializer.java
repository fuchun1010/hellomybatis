package com.tank.deseria;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.tank.domain.tree.Container;
import com.tank.domain.tree.Item;
import com.tank.domain.tree.Node;

import java.io.IOException;
import java.util.Objects;

public class ItemDeserializer extends StdDeserializer<Item> {

  public ItemDeserializer() {
    this(null);
  }

  public ItemDeserializer(Class<?> clazz) {
    super(clazz);
  }

  @Override
  public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    JsonNode node = jsonParser.getCodec().readTree(jsonParser);
    String id = node.get("id").textValue();
    String pid = node.get("pid").textValue();
    JsonNode tagIdNode = node.get("tagId");
    if (Objects.isNull(tagIdNode)) {
      String name = node.get("name").textValue();
      Container container = new Container();
      container.setName(name);
      container.setId(id);
      container.setPid(pid);
      return container;
    } else {
      String desc = node.get("desc").textValue();
      int count = node.get("count").intValue();
      Node tmp = new Node();
      tmp.setId(id);
      tmp.setPid(pid);
      tmp.setCount(count);
      tmp.setDesc(desc);
      tmp.setTagId(tagIdNode.textValue());
      return tmp;
    }
  }
}