package org.example.url.service.userService;

import lombok.RequiredArgsConstructor;
import org.example.config.PasswordConfigurer;
import org.example.url.dao.userDao.UserDao;
import org.example.url.domains.AuthDomain;
import org.example.url.dto.userDto.AuthCreateDto;
import org.example.url.enams.UserStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 29/07/22 08:32 (Friday)
 * Spring_mvc/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao dao;
    private final PasswordConfigurer configurer;

    public void register(AuthCreateDto authCreateDto) {
        String encode = configurer.encode(authCreateDto.getPassword());
        AuthDomain authDomain= AuthDomain.builder()
                .firstname(authCreateDto.getFirstname())
                .lastname(authCreateDto.getLastname())
                .username(authCreateDto.getUsername())
                .password(encode)
                .build();
        dao.save(authDomain);
    }

    public void login(String username, HttpServletRequest request) {
        AuthDomain user=dao.findByUsername(username);
        System.out.println("-----------"+user);
        if(Objects.isNull(user)){
            throw new RuntimeException("User not found");
        }
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
    }
}
