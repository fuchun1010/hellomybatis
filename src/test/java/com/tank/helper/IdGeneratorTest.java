package com.tank.helper;

import lombok.val;
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
    String storeCode = "790045";
    String value = this.idGenerator.generateOrderId(storeCode);
    //Assert.assertTrue("j8569*o3gt00001".equalsIgnoreCase(value));
    System.out.println("order is:" + value);
    Triplet<Integer, Integer, Integer> orderStructure = this.idGenerator.toRawOrderId(value);
    System.out.println("date=" + orderStructure.getValue0());
    System.out.println("store=" + orderStructure.getValue1());
    System.out.println("orderId=" + orderStructure.getValue2());
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId2() {
    String storeCode = "0084";
    String value = this.idGenerator.generateOrderId(storeCode);
    System.out.println("order is:" + value);
    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId3() {
    String storeCode = "k20211";
    String value = this.idGenerator.generateOrderId(storeCode);
    System.out.println("order is:" + value);
    Assert.assertTrue(value.length() == 15);
  }



  @Test
  public void generateOrderId4() {
    char k = 'k';
    int c = (int)k;
    System.out.println(c);
  }

  @Test
  public void generateOrderId5() {
//    String value = this.idGenerator.generateOrderId(seq5);
//    System.out.println("order is:" + value);
//    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId6() {
//    String value = this.idGenerator.generateOrderId(seq6);
//    Assert.assertTrue(value.length() == 15);
  }

  @Test
  public void generateOrderId7() {
//
  }

  @Test
  public void toRawOrderId() {
    final String orderId = "j8569*o3gt00001";
    Triplet<Integer, Integer, Integer> rs = this.idGenerator.toRawOrderId(orderId);
    Assert.assertTrue(rs.getValue0() == 20190409);
    Assert.assertTrue(rs.getValue1() == 790045);
    Assert.assertTrue(rs.getValue2() == 1);

  }

  @Test
  public void testHex() {
    val xx = Integer.parseInt("987", 64);
    System.out.println(xx);

  }

  @Test
  public void testId() {
    System.out.println(Long.MAX_VALUE);
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