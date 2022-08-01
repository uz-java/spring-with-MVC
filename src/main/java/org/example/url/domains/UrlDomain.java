package org.example.url.domains;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:37 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlDomain {
    private Long id;
    private String originalUrl;
    private String shortenedUrl;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime validTill;

    @Builder.Default
    private Long createdBy=-1L;
}
