package com.tank.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.base.Preconditions;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.Objects;

/**
 * @author
 */
@Configuration
public class AppConfig {

  @Bean("dataSource")
  public DruidDataSource initDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    String driver = environment.getProperty("rdb.mysql.driver");
    String url = environment.getProperty("rdb.mysql.url");
    String username = environment.getProperty("rdb.mysql.username");
    String password = environment.getProperty("rdb.mysql.password");
    String validateQuery = environment.getProperty("rdb.mysql.druid.validation-query");
    String maxWait = environment.getProperty("rdb.mysql.druid.maxWait");
    String queryTimeOut = environment.getProperty("rdb.mysql.druid.query-timeout");
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setValidationQuery(validateQuery);
    dataSource.setMaxWait(Long.parseLong(maxWait));
    dataSource.setQueryTimeout(Integer.parseInt(queryTimeOut));
    return dataSource;
  }

  @Bean
  public DataSourceTransactionManager initTransactionManager(@Qualifier("dataSource") @Autowired DruidDataSource druidDataSource) {
    return new DataSourceTransactionManager(druidDataSource);
  }

  @Bean
  public SqlSessionFactory initSqlSessionFactory(@Qualifier("dataSource") @Autowired DruidDataSource druidDataSource) throws Exception {
    Preconditions.checkArgument(Objects.nonNull(druidDataSource), "data source not allowed null");
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(druidDataSource);
    return sqlSessionFactoryBean.getObject();
  }

  @Autowired
  private Environment environment;
}
