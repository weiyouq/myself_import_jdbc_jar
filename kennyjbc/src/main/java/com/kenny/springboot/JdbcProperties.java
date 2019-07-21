package com.kenny.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kenny_peng
 * @created 2019/7/21 下午4:39
 */
@ConfigurationProperties(prefix = "spring.datasource")//使用springboot的注解，自动读取配置文件中的spring.datasource信息
public class JdbcProperties {
    private String url;
    private String driverClass;
    private String username;
    private String password;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
