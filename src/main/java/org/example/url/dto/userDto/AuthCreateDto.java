package org.example.url.dto.userDto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author "Tojaliyev Asliddin"
 * @since 29/07/22 08:31 (Friday)
 * Spring_mvc/IntelliJ IDEA
 */
@Getter
@Setter
public class AuthCreateDto {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String confirmPassword;
}
