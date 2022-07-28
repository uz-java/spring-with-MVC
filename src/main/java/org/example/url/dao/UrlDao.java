package org.example.url.dao;

import lombok.RequiredArgsConstructor;
import org.example.url.domains.UrlDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:52 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@Repository
@RequiredArgsConstructor
public class UrlDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(UrlDomain urlDomain) {
        String sql = """
                insert into url(originalUrl,shortenedUrl,description,validTill)
                values (?,?,?,?);
                """;
        jdbcTemplate.update(sql, urlDomain.getOriginalUrl(), urlDomain.getShortenedUrl(), urlDomain.getDescription(), urlDomain.getValidTill());
    }

    public List<UrlDomain> getAll(){
        String sql="select * from url";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UrlDomain.class));
    }

    public UrlDomain findByShortenedUrl(String shortenedUrl){
        String sql="select * from url t where t.shortenedUrl=?";
        return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(UrlDomain.class),shortenedUrl);
    }
}
