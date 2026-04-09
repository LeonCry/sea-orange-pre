package com.voidis.sea_orange_pre.controller;


import com.voidis.sea_orange_pre.common.Result;
import com.voidis.sea_orange_pre.entity.User;
import com.voidis.sea_orange_pre.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
    private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result<User> register(@RequestBody User registerUser) {
        User user = this.userService.register(registerUser);
        return Result.OK(user);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody User loginUser) {
        return Result.OK(this.userService.login(loginUser));
    }
}
