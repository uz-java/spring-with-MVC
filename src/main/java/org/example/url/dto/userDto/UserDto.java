package org.example.url.dto.userDto;

import lombok.*;
import org.example.url.enams.UserStatus;

/**
 * @author "Tojaliyev Asliddin"
 * @since 29/07/22 08:31 (Friday)
 * Spring_mvc/IntelliJ IDEA
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private UserStatus status;
}
