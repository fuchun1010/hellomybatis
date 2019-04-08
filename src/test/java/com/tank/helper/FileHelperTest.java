package com.tank.helper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileHelperTest {

  @Test
  public void loadFile() {
    try {
      File file = fileHelper.loadFile("store.csv");
      Assert.assertTrue(file.exists());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Autowired
  private FileHelper fileHelper;
}