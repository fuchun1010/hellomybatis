package com.tank.helper;

import org.javatuples.Triplet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdGeneratorTest {

  @Test
  public void generateOrderId1() {
    String value = this.idGenerator.generateOrderId(seq1);
    Assert.assertTrue("j8569*o3gt00001".equalsIgnoreCase(value));
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId2() {
    String value = this.idGenerator.generateOrderId(seq2);
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId3() {
    String value = this.idGenerator.generateOrderId(seq3);
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId4() {
    String value = this.idGenerator.generateOrderId(seq4);
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId5() {
    String value = this.idGenerator.generateOrderId(seq5);
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId6() {
    String value = this.idGenerator.generateOrderId(seq6);
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId7() {
    String value = this.idGenerator.generateOrderId(seq7);
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void toRawOrderId() {
    final String orderId = "j8569*o3gt00001";
    Triplet<Integer, Integer, Integer> rs = this.idGenerator.toRawOrderId(orderId);
    Assert.assertTrue(rs.getValue0() == 20190409);
    Assert.assertTrue(rs.getValue1() == 790045);
    Assert.assertTrue(rs.getValue2() == 1);
   
  }

  @Autowired
  private IdGenerator idGenerator;

  private Integer seq7 = 100000;

  private Integer seq6 = 10000;

  private Integer seq5 = 1000;

  private Integer seq4 = 100;

  private Integer seq3 = 100;

  private Integer seq2 = 10;

  private Integer seq1 = 1;


}