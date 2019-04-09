package com.tank.config;

import com.tank.helper.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author fuchun
 */
@Configuration
public class RedisConf {

  @Bean
  public JedisConnectionFactory initJedisConnectionFactory() {
    return new JedisConnectionFactory(this.initStandaloneRedisConfig());
  }

  @Bean
  public RedisScript<String> initRedisScript() {
    File file = null;
    try {
      file = this.fileHelper.loadFile("plusRepository.lua");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String path = file.getAbsolutePath();
    ScriptSource scriptSource = new ResourceScriptSource(new FileSystemResource(file));
    RedisScript redisScript = null;
    try {
      redisScript = RedisScript.of(scriptSource.getScriptAsString(), String.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return redisScript;
  }

  private RedisStandaloneConfiguration initStandaloneRedisConfig() {
    final RedisStandaloneConfiguration conf = new RedisStandaloneConfiguration();
    String url = env.getProperty("spring.redis.url");
    Integer port = Integer.parseInt(env.getProperty("spring.redis.port"));
    Integer db = Integer.parseInt(env.getProperty("spring.redis.db"));
    conf.setDatabase(db);
    conf.setHostName(url);
    conf.setPort(port);
    return conf;
  }


  @Autowired
  private Environment env;

  @Autowired
  private FileHelper fileHelper;
}
