package com.tank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author fuchun
 */
@Configuration
public class RedisConf {

  @Bean
  public JedisConnectionFactory initJedisConnectionFactory() {
    final RedisStandaloneConfiguration conf = this.initStandaloneRedisConfig();
    final JedisConnectionFactory factory = new JedisConnectionFactory(conf);
    return factory;
  }


  @Bean(name = "redisTemplate")
  public RedisTemplate<String, String> initRedisTemplate(@Autowired JedisConnectionFactory jedisConnectionFactory) {
    final RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory);
    return redisTemplate;
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
}
