package org.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller {

    protected static String URI;

    @Override
    public ModelAndView handleRequest(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) {
        URI = request.getServletPath();
        String method = request.getParameter("_method");
        if (method == null || method.isEmpty()) {
            method = request.getMethod();
        }

        return switch (method.toUpperCase()) {
            case "GET" -> handleGetRequest(request, response);
            case "POST" -> handlePostRequest(request, response);
            case "DELETE" -> handleDeleteRequest(request, response);
            case "PUT" -> handlePutRequest(request, response);
            default -> new ModelAndView("redirect:/user"); // change to redirect to error page
        };
    }

    protected ModelAndView handleGetRequest(HttpServletRequest request, HttpServletResponse response) {
        // OVERRIDE TO USE
        return null;
    }

    protected ModelAndView handlePostRequest(HttpServletRequest request, HttpServletResponse response) {
        // OVERRIDE TO USE
        return null;
    }

    protected ModelAndView handleDeleteRequest(HttpServletRequest request, HttpServletResponse response) {
        // OVERRIDE TO USE
        return null;
    }

    protected ModelAndView handlePutRequest(HttpServletRequest request, HttpServletResponse response) {
        // OVERRIDE TO USE
        return null;
    }
}
