package com.hb.spr.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class PublicControllerAdvice {
    
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        
        modelAndView.addObject("errorMessage", e.getMessage());
        
        return modelAndView;
    }
    
    @ModelAttribute
    public void addAttr(Model model){
        model.addAttribute("说明", "假的请求");
    }
    
}
