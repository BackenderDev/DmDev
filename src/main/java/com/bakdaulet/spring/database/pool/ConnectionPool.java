package com.bakdaulet.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool{
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;
//    private final List<Object> args;
//    private final Map<String, Object> properties;


    @PostConstruct
    private void init() {
        log.info("Init connection pool");
    }


    @PreDestroy
    private void destroy() {
        log.info("Clean connection pool");
    }
}