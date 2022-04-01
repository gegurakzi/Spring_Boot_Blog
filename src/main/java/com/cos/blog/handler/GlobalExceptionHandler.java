package com.cos.blog.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleExceptionDebugging(Exception e) { return "e"; }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String handleIllegalArgException(IllegalArgumentException e){
        return "<h1>"+e.getMessage()+"</h1>";
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException e){
        return "<h1>"+e.getMessage()+"</h1>";
    }
}
