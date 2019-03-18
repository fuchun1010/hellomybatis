package com.tank.domain.tree;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tank.deseria.ItemDeserializer;
import lombok.Data;

@Data
@JsonDeserialize(using = ItemDeserializer.class)
public abstract class Item {

  private String id;

  private String pid;
}
