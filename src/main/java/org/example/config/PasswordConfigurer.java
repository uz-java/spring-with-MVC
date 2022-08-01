package org.example.config;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Configuration;

/**
 * @author "Otajonov Dilshodbek
 * @since 7/10/22 9:23 AM (Sunday)
 * lib16/IntelliJ IDEA
 */
@Configuration
public class PasswordConfigurer {
    public  String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }

    public  boolean matchPassword(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }

}
