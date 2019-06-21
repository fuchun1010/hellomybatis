package com.tank.domain.mapper;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuchun
 */
@Data
public class RecordRes {

  private List<Record> records = new ArrayList<>();
}
