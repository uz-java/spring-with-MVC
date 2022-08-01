package org.example.database;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:48 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
//@Component
public class Init implements ApplicationContextAware {

    /*@Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String dropUrlTableIfExists = "drop table if exists url;";
        jdbcTemplate.execute(dropUrlTableIfExists);
        String createTable = """
                create table url(
                id bigserial primary key ,
                originalUrl varchar not null ,
                shortenedUrl varchar not null ,
                description varchar,
                validTill timestamp not null default current_timestamp + interval '10 minutes',
                createdAt timestamp not null default current_timestamp)
                """;
        jdbcTemplate.execute(createTable);
    }*/

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String dropUrlTableIfExists = "drop table if exists users;";
        jdbcTemplate.execute(dropUrlTableIfExists);
        String createTable = """
                create table users(
                id bigserial primary key ,
                firstname varchar ,
                lastname varchar ,
                username varchar not null ,
                password varchar not null)
                """;
        jdbcTemplate.execute(createTable);
    }
}
