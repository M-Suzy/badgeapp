package com.practice.badgeapp.controller;

import com.practice.badgeapp.repository.UserRepository;
import com.practice.badgeapp.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@Api( tags = "Users")
public class UserController {
    UserService userService;
    UserRepository userRepository;

    UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

}
