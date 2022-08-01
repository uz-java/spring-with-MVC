package org.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:47 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@Getter
@Setter
@Component
@PropertySource("classpath:datasource.properties")
public class DBProperties {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver}")
    private String driver;
}
