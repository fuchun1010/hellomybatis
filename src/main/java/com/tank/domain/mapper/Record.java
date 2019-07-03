package com.tank.domain.mapper;

import lombok.Data;

import java.util.Date;

/**
 * @author fuchun
 */
@Data
public class Record {

  private String id;

  private String pid;

  private String tagId;

  private String name;

  private Boolean isEnable;
}
