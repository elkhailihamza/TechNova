package org.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {
    @Override
    public ModelAndView handleRequest(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "input db message here");
        return modelAndView;
    }
}
