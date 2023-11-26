package com.bakdaulet.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "db")
public record DatabaseProperties(String password,
                                String username,
                                String driver,
                                String url,
                                String hosts,
                                PoolProperties pool,
                                List<PoolProperties> pools,
                                Map<String, Object> properties) {

    public static record PoolProperties(Integer size,
                                        Integer timeout){
    }
}
