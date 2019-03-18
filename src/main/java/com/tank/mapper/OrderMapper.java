package com.tank.mapper;

import com.tank.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fuchun
 */
@Mapper
public interface OrderMapper {

  @Results(id = "allOrders", value = {
      @Result(property = "id", column = "_id", id = true),
      @Result(property = "address", column = "_address"),
      @Result(property = "sender", column = "_sender"),
      @Result(property = "postDate", column = "_postDate")
  })
  @Select("select _id, _address, _sender, DATE_FORMAT(_postDate, '%Y-%m-%d %H:%i:%s') as postDate from tab_orders limit 100")
  List<Order> queryAll();
}
