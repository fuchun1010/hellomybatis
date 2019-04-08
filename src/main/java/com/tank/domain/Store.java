package com.tank.domain;

import lombok.Data;

import java.util.Comparator;

@Data
public class Store implements Comparator<Store> {


  private String name;

  private String code;


  @Override
  public int compare(Store o1, Store o2) {
    return o1.getCode().compareTo(o2.getCode());
  }
}
