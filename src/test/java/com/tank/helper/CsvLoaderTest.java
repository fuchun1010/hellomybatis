package com.tank.helper;

import com.tank.domain.Store;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvLoaderTest {

  @Test
  public void loadCsv2Store() {
    this.stores.ifPresent(allStores -> Assert.assertTrue(allStores.size() > 0));
  }

  @Test
  public void testMax() {
    try {
      String ip = InetAddress.getLocalHost().toString().replace(".","");

      System.out.println(ip);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    System.out.println("年月日-->" + Integer.toString(20180407, 32));
    System.out.println("id-->" + Integer.toString(1, 32));
    System.out.println("门店编号" + Integer.toString(79, 32));
    System.out.println("j7rdn"+"9h5jv"+"***2f");
  }


  @Before
  public void init() {
    this.stores = csvLoader.loadCsv2Store("store.csv");
  }

  @Autowired
  private CsvLoader csvLoader;

  Optional<List<Store>> stores;
}