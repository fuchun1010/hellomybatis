package com.tank.helper;

import com.google.common.collect.Lists;
import com.tank.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author fuchun
 */
@Component
public class CsvLoader {

  public Optional<List<Store>> loadCsv2Store(@Nonnull final String csvFileName) {
    try {
      List<String> special = Arrays.asList("1", "store_code");
      File file = this.fileHelper.loadFile(csvFileName);
      List<Store> stores = Lists.newLinkedList();
      try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
        while (true) {
          String line = in.readLine();
          if (Objects.isNull(line)) {
            break;
          }
          String[] values = line.split(",");
          boolean isOk = Objects.nonNull(values) && values.length > 0 && !special.contains(values[0]);
          if (!isOk) {
            continue;
          }
          Store store = new Store();
          store.setCode(values[0]);
          store.setName(values[1]);
          stores.add(store);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      return Optional.ofNullable(stores);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return Optional.empty();
    }


  }

  @Autowired
  private FileHelper fileHelper;
}
