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


  public String generateOrderId(Integer seq) {
    StringBuffer sb = new StringBuffer();
    String date = this.defaultYearMonthDay();
    String store = this.storeCode(790045);
    String orderId = this.orderSeq(seq);
    StringJoiner joiner = new StringJoiner("");
    joiner.add(date);
    joiner.add(store);
    joiner.add(orderId);
    return joiner.toString();
  }

  public Triplet<Integer, Integer, Integer> toRawOrderId(final String orderId) {
    Preconditions.checkArgument(orderId.trim().length() == 15, "invalidate orderId");
    Integer date = Integer.parseInt(orderId.substring(0, 5), 32);
    Integer storeID = Integer.parseInt(orderId.substring(5, 10).replace("*", ""), 32);
    //orderId.substring(10, 15)
    Integer seq = Integer.parseInt(removeLeftZeroChar(orderId.substring(10, 15)));
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

  private String storeCode(@Nonnull final Integer code) {
    String value = Integer.toString(code, 32);
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
