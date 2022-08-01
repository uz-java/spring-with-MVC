package org.example.url.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.example.annotations.ValidLocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:50 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlCreateDto {
    @NotBlank(message = "Original name can not be null")
    @Pattern(regexp = "^(https://|http://).*",message = "Must be valid link exl(olx.uz)")
    private String originalUrl;

    private String description;

    @ValidLocalDateTime(message = "value for expiration field invalid")
    private String validTill;

    @JsonIgnore
    private LocalDateTime expiration;
}
