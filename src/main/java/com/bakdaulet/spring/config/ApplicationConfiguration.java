package com.bakdaulet.spring.config;

import com.bakdaulet.spring.database.pool.ConnectionPool;
import com.bakdaulet.spring.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import com.web.config.WebConfiguration;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration
//@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages = "com.bakdaulet.spring",
//        useDefaultFilters = false,
//        includeFilters = {
//                @Filter(type = FilterType.ANNOTATION, value = Component.class),
//                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
//                @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
//        })
public class ApplicationConfiguration {

        @Bean("pool2")
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool2(@Value("${db.username}") String username){
                return new ConnectionPool(username, 2);
        }
        @Bean
        public ConnectionPool pool3(){
                return new ConnectionPool("test-pool", 30);
        }

        @Bean
//        @Profile("prod|web")
        // ! & |
        public UserRepository userRepository2(ConnectionPool pool2){
                return new UserRepository(pool2);
        }

        @Bean
        public UserRepository userRepository3(){
                var connectionPool1 = pool3();
                var connectionPool2 = pool3();
                var connectionPool3 = pool3();
                return new UserRepository(pool3());
        }
}