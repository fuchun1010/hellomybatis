package com.tank.constant;

/**
 * @author fuchun
 * @date 2019-04-07
 */
public enum Result {


  SUCCESS(1), FAILURE(0);

  private Result(int rs) {
    this.rs = rs;
  }

  private int rs;
}
