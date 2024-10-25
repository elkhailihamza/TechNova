package org.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.project.model.User;
import org.project.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class UserController extends MainController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView handleGetRequest(HttpServletRequest request, HttpServletResponse response) {
        Iterable<User> users = userService.fetchAll();
        request.setAttribute("users", users);
        return new ModelAndView("user");
    }

    @Override
    protected ModelAndView handlePostRequest(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        userService.save(user);
        return new ModelAndView("redirect:/user");
    }
}
