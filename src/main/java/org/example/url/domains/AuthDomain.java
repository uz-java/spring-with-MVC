package org.example.url.domains;

import lombok.*;
import org.example.url.enams.UserStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author "Tojaliyev Asliddin"
 * @since 29/07/22 08:14 (Friday)
 * Spring_mvc/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthDomain {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;

 /*   @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.USER;*/
}
