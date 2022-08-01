package org.example.url.dao.userDao;

import lombok.RequiredArgsConstructor;
import org.example.url.domains.AuthDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 29/07/22 08:23 (Friday)
 * Spring_mvc/IntelliJ IDEA
 */

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(AuthDomain user) {
        String sql = """
                insert into users(firstname,lastname,username,password)
                values (?,?,?,?);
                """;
        jdbcTemplate.update(sql,user.getFirstname(),user.getLastname(),user.getUsername(),user.getPassword());
    }

    public List<AuthDomain> getAll(){
        String sql="select * from users";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AuthDomain.class));
    }

    public AuthDomain findByUsername(String username){
        String sql="select * from users t where t.username=?";
        return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(AuthDomain.class),username);
    }
}
