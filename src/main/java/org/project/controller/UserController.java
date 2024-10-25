package org.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.project.model.User;
import org.project.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

public class UserController extends MainController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected ModelAndView handleGetRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = null;

        switch (URI) {
            case "/user":
                Iterable<User> users = userService.fetchAll();
                modelAndView = new ModelAndView("user");
                modelAndView.addObject("users", users);
                break;
            case "/user/update":
                String user_id = request.getParameter("id");
                if (user_id != null && !user_id.isBlank()) {
                    long id = Long.parseLong(user_id);
                    User user = userService.fetchById(id);
                    modelAndView = new ModelAndView("user_update");
                    modelAndView.addObject("user", user);
                }
                break;
            default:
                // Handle unknown URIs
                break;
        }
        return modelAndView;
    }


    @Override
    protected ModelAndView handlePostRequest(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        userService.save(user);
        return new ModelAndView("redirect:/user");
    }

    @Override
    protected ModelAndView handleDeleteRequest(HttpServletRequest request, HttpServletResponse response) {
        String user_id = request.getParameter("id");
        if (user_id != null && !user_id.isBlank()) {
            long id = Long.parseLong(user_id);
            User user = userService.fetchById(id);
            if (!Objects.equals(user, null)) {
                userService.delete(user);
            }
        }
        return new ModelAndView("redirect:/user");
    }

    @Override
    protected ModelAndView handlePutRequest(HttpServletRequest request, HttpServletResponse response) {
        String user_id = request.getParameter("id");
        if (user_id != null && !user_id.isBlank()) {
            long id = Long.parseLong(user_id);
            User user = userService.fetchById(id);

            String username = request.getParameter("username");

            if (!Objects.equals(user, null)) {
                user.setUsername(username);
                userService.update(user);
            }
        }
        return new ModelAndView("redirect:/user");
    }
}
