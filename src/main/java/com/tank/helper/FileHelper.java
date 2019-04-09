package com.tank.helper;

import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author fuchun
 */
@Component
public class FileHelper {

  public File loadFile(@Nonnull final String fileName) throws FileNotFoundException {
    String path = System.getProperty("user.dir");
    File file = new File(path + File.separator + "config" + File.separator + fileName);
    if (!file.exists()) {
      throw new FileNotFoundException(file.getAbsolutePath() + " not exists");
    }

    return file;
  }
}
