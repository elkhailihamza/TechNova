package org.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;


public class HomeController implements Controller {
    @Override
    public ModelAndView handleRequest(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "Welcome to the Home Page!");
        return modelAndView;
    }
}
