package com.tank.helper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author fuchun
 * @date 2019-04-08
 */
@Component
public class DateHelper {

  public String currentDefaultDate() {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    return dateTimeFormatter.format(LocalDate.now());
  }


}
