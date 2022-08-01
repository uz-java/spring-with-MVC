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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
    public ModelAndView homePage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        System.out.println("homePage--- "+user);
        if (Objects.isNull(user)) {
            return new ModelAndView("loginPage");
        }
        ModelAndView modelAndView = new ModelAndView("viewUrl");
        List<UrlDomain> urlDomains = service.findAll();
        modelAndView.addObject("msg", urlDomains);
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

        try {
            TimeUnit.SECONDS.sleep(1);
            response.sendRedirect(urlDomain.getOriginalUrl());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/viewUrl/{pageId}")
    public String edit(@PathVariable int pageId,Model model){
        int limit=5;
        int offset=(limit*pageId)-limit;

        List<UrlDomain> urlDomainsList=service.findAll();
        int size=urlDomainsList.size();
        int sub=size/limit+1;

        List<Integer> subs=new ArrayList<>();
        for (int i = 0; i < sub; i++) {
            subs.add(i);
        }

        model.addAttribute("subs",subs);
        System.out.println("pageId--- "+pageId);

        List<UrlDomain> urlDomains=service.getUrlsByPage(limit,offset);
        model.addAttribute("msg",urlDomains);
        return "viewUrl";
    }
}
