package com.tank.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RepositoryHelper {


  public void plusRepository() {
    String value = this.redisTemplate.execute(this.redisScript, Arrays.<String>asList("dis", "ss01", "ss02"), Arrays.<String>asList("0001", "100", "100").toArray());
    System.out.println("value = " + value);
  }


  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private RedisScript<String> redisScript;
}
