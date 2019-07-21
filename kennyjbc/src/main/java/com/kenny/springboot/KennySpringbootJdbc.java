package com.kenny.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author kenny_peng
 * @created 2019/7/21 下午4:29
 */
//用代码实现相关定义，替代xml配置文件
@Configuration  //标示这个类，和xml配置文件的功能类似
@EnableConfigurationProperties(JdbcProperties.class)
public class KennySpringbootJdbc {

    /**
     * springboot推荐配置专成对象
     * 获取datasource，并将配置数据库连接信息
     * @return  数据库连接对象
     */
    @ConditionalOnProperty(name="kenny.study.jdbcstart.enable", havingValue = "true")//判断条件是否满足
    @Bean //类似与xml中的bean配置
    public DruidDataSource getDataSource(JdbcProperties jdbcProperties){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setDriverClassName(jdbcProperties.getDriverClass());
        dataSource.setPassword(jdbcProperties.getPassword());

        return dataSource;
    }

    @Bean   //这个方法交给spring调用，返回的对象交给spring ioc容器管理，用到的参数，由spring提供
    public JdbcTemplate getJdbcTemplet(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }





}
