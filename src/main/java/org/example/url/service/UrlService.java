package org.example.url.service;

import org.example.url.dao.UrlDao;
import org.example.url.domains.UrlDomain;
import org.example.url.dto.UrlCreateDto;
import org.example.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:52 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@Service
public class UrlService {
    private final UrlDao dao;

    public UrlService(UrlDao dao) {
        this.dao = dao;
    }

    public void generate(UrlCreateDto dto) {
        dto.setExpiration(StringUtils.hasText(dto.getValidTill())
                ? Utils.toLocalDateTime(dto.getValidTill())
                : LocalDateTime.now(Clock.systemDefaultZone()).plusDays(10));

        String shortenedUrl = DigestUtils.md5DigestAsHex(dto.getOriginalUrl().getBytes());
        UrlDomain urlDomain = UrlDomain.builder()
                .originalUrl(dto.getOriginalUrl())
                .createdAt(LocalDateTime.now())
                .description(dto.getDescription())
                .validTill(dto.getExpiration())
                .shortenedUrl(shortenedUrl)
                .build();
        dao.save(urlDomain);
    }

    public List<UrlDomain> findAll() {
        return dao.getAll();
    }

    public UrlDomain findByShortenedUrl(String shortenedUrl) {
        return dao.findByShortenedUrl(shortenedUrl);
    }

    public List<UrlDomain> getUrlsByPage(int limit, int offset) {
        return dao.getAllUrlsByPage(limit,offset);
    }
}
