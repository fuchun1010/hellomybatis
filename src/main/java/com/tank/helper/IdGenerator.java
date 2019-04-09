package com.tank.helper;

import com.google.common.base.Preconditions;
import com.tank.service.IOrder;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author fuchun
 */
@Component
public class IdGenerator {


  public String generateOrderId(@Nonnull final String storeCode) {
    Preconditions.checkArgument(storeCode.length() <= 6);
    StringBuffer sb = new StringBuffer();
    String date = this.defaultYearMonthDay();
    //790045
    String store = this.storeCode(storeCode);
    Integer orderSeq = this.orderService.retrieveOrderId();
    String orderId = this.orderSeq(orderSeq);
    StringJoiner joiner = new StringJoiner("");
    joiner.add(date);
    joiner.add(store);
    joiner.add(orderId);
    return joiner.toString().toUpperCase();
  }

  public Triplet<Integer, Integer, Integer> toRawOrderId(final String orderId) {
    Preconditions.checkArgument(orderId.trim().length() == 15, "invalidate orderId");
    String tmpOrderID = orderId.toLowerCase();
    Integer date = Integer.parseInt(tmpOrderID.substring(0, 5), 32);
    Integer storeID = Integer.parseInt(tmpOrderID.substring(5, 10).replace("*", ""), 32);
    //orderId.substring(10, 15)
    Integer seq = Integer.parseInt(removeLeftZeroChar(tmpOrderID.substring(10, 15)),32);
    return Triplet.with(date, storeID, seq);
  }


  private String removeLeftZeroChar(final String seq) {
    int start = 0;
    for (int i = 0; i < seq.length(); i++) {
      if (seq.charAt(i) == '0') {
        start++;
      } else {
        break;
      }
    }

    return seq.substring(start);
  }


  private String defaultYearMonthDay() {
    String date = dateHelper.currentDefaultDate();
    Integer value = Integer.parseInt(date);
    return this.addLeftChart(Integer.toString(value, 32));
  }

  private String storeCode(@Nonnull final String code) {

    int start = 0;
    int size = code.length();
    for (int i = 0; i < size; i++) {
      char a = code.charAt(i);
      if (a == '0') {
        start++;
      } else {
        break;
      }
    }

    int tmpCode = Integer.parseInt(code.substring(start));

    String value = Integer.toString(tmpCode, 32);
    value = this.addLeftChart(value);
    return value;
  }

  private String orderSeq(@Nonnull final Integer seq) {
    String value = Integer.toString(seq, 32);
    value = this.addLeftChart(value, 5, "0");
    return value;
  }


  private String addLeftChart(@Nonnull final String value, int maxLength, final String separator) {
    if (value.length() == maxLength) {
      return value;
    }
    int diff = maxLength - value.length();
    List<String> lackedChart = IntStream.rangeClosed(1, diff).<String>mapToObj(index -> separator).collect(Collectors.toList());
    lackedChart.add(value);
    StringBuffer sb = new StringBuffer();
    for (String str : lackedChart) {
      sb.append(str);
    }
    return sb.toString();
  }


  /**
   * @return
   */
  private String addLeftChart(@Nonnull final String value) {
    return addLeftChart(value, 5, "*");
  }

  @Autowired
  private IOrder orderService;

  @Autowired
  private DateHelper dateHelper;

}
