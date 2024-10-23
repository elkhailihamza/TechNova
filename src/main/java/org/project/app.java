package org.project;

import org.project.model.User;
import org.project.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        User user = userService.getUser();
        System.out.println(user.getUsername()+" "+user.getPassword());
    }
}
