package com.tank.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateHelperTest {

  @Test
  public void testComponent() {
    System.out.println(this.dateHelper);
    assertTrue(Objects.nonNull(this.dateHelper));
  }

  @Test
  public void currentDateWithoutHour() {

  }

  @Autowired
  private DateHelper dateHelper;

}