package org.example.url.controller.userController;

import lombok.RequiredArgsConstructor;
import org.example.url.dto.userDto.AuthCreateDto;
import org.example.url.dto.userDto.AuthLoginDto;
import org.example.url.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author "Tojaliyev Asliddin"
 * @since 31/07/22 20:39 (Sunday)
 * Spring_mvc/IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String authRegisterPage(@ModelAttribute("authCreateDto") AuthCreateDto authCreateDto) {
        return "/registerPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String authRegister(@ModelAttribute("authCreateDto") @Valid AuthCreateDto authCreateDto, BindingResult result) {
        if (result.hasErrors() || !authCreateDto.getPassword().equals(authCreateDto.getConfirmPassword())) {
            return "registerPage";
        } else {
            userService.register(authCreateDto);
            return "loginPage";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String authLoginPage(@ModelAttribute("authCreateDto") AuthCreateDto authCreateDto) {
        return "/loginPage";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String authLogin(@ModelAttribute("authLoginDto") AuthLoginDto authLoginDto, HttpServletRequest request, BindingResult result) {
        if(result.hasErrors()){
            return "/loginPage";
        }else {
            userService.login(authLoginDto.getUsername(),request);
            return "redirect:/";
        }
    }

}
