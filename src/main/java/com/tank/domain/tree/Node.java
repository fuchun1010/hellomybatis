package com.tank.domain.tree;

import lombok.Data;

/**
 * @author fuchun
 */
@Data
public class Node extends Item {

  private String tagId = "";

  private int count = 0;

  private String desc = "";


}
