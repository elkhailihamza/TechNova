package org.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller {

    @Override
    public ModelAndView handleRequest(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) {
        String method = request.getParameter("_method");
        if (method == null || method.isEmpty()) {
            method = request.getMethod();
        }

        if ("POST".equalsIgnoreCase(method)) {
            return handlePostRequest(request, response);
        }
        return handleGetRequest(request, response);

        // CHANGE TO GIVE ERROR, OR REDIRECT BACK TO HOME IF ACTION GIVEN DOESN'T EXIST
    }

    protected ModelAndView handleGetRequest(HttpServletRequest request, HttpServletResponse response) {
        // OVERRIDE TO USE
        return null;
    }

    protected ModelAndView handlePostRequest(HttpServletRequest request, HttpServletResponse response) {
        // OVERRIDE TO USE
        return null;
    }
}
