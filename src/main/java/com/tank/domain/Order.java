package com.tank.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Order {

  private long id;

  private String address;

  private String receiver;

  private String sender;

  private String postDate;
}
