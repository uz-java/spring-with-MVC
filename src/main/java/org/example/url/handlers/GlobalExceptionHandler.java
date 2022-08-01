package org.example.url.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:49 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handler_404(NoHandlerFoundException e){
        return "error/404";
    }
}
