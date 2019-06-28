package com.tank.domain.tree;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fuchun
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class Node extends Item {

  private String tagId = "";

  private Boolean isEnable = true;

}
