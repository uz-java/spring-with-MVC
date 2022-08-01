package org.example.url.dao;

import lombok.RequiredArgsConstructor;
import org.example.url.domains.UrlDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<UrlDomain> getAll() {
        String sql = "select * from url";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UrlDomain.class));
    }

    public UrlDomain findByShortenedUrl(String shortenedUrl) {
        String sql = "select * from url t where t.shortenedUrl=?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(UrlDomain.class), shortenedUrl);
    }

    public List<UrlDomain> getAllUrlsByPage(int limit, int offset) {
        String query = "select * from url limit " + limit + " offset " + offset;

        return jdbcTemplate.query(query, new RowMapper<UrlDomain>() {

            @Override
            public UrlDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
                UrlDomain urlDomain = new UrlDomain();
                urlDomain.setId(rs.getLong(1));
                urlDomain.setOriginalUrl(rs.getString(2));
                urlDomain.setShortenedUrl(rs.getString(3));
                urlDomain.setDescription(rs.getString(4));
                urlDomain.setValidTill(rs.getTimestamp(5).toLocalDateTime());
                urlDomain.setCreatedAt(rs.getTimestamp(6).toLocalDateTime());
                return urlDomain;
            }
        });
    }
}
