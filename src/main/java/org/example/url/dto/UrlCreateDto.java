package org.example.url.dto;

import lombok.*;

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
    private String originalUrl;
    private String description;
    private String validTill;
}
