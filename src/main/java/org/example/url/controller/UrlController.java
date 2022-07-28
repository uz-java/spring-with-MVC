package org.example.url.controller;

import lombok.RequiredArgsConstructor;
import org.example.url.domains.UrlDomain;
import org.example.url.dto.UrlCreateDto;
import org.example.url.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:51 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class UrlController {
    private final UrlService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<UrlDomain> urlDomains = service.findAll();
        modelAndView.addObject("urls", urlDomains);
        return modelAndView;
    }

    @RequestMapping(value = "/gen/", method = RequestMethod.GET)
    public String urlGeneratePage(Model model) {
        model.addAttribute("dto", new UrlCreateDto());
        return "gen/url-generate-page";
    }

    @RequestMapping(value = "/gen/", method = RequestMethod.POST)
    public String urlGenerate(@Valid @ModelAttribute("dto") UrlCreateDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "gen/url-generate-page";
        }
        service.generate(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "/go/{shortenedUrl}", method = RequestMethod.GET)
    public void urlGeneratePage(@PathVariable String shortenedUrl, HttpServletResponse response) throws IOException {
        UrlDomain urlDomain = service.findByShortenedUrl(shortenedUrl);
        response.sendRedirect(urlDomain.getOriginalUrl());
    }
}
