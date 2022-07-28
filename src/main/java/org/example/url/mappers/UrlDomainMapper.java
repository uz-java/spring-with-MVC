package org.example.url.mappers;

import org.example.url.domains.UrlDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:49 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
public class UrlDomainMapper implements RowMapper<UrlDomain> {

    @Override
    public UrlDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UrlDomain.builder()
                .id(rs.getLong("id"))
                .originalUrl(rs.getString("originalUrl"))
                .shortenedUrl(rs.getString("shortenedUrl"))
                .description(rs.getString("description"))
                .validTill(rs.getTimestamp("validTill").toLocalDateTime())
                .createdAt(rs.getTimestamp("createdAt").toLocalDateTime())
                .build();
    }
}
