package com.shopdev.controller;


import com.shopdev.entity.user.UserEntity;
import com.shopdev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/user")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String name, @RequestParam String email) {
        return userService.findByUserNameAndUserEmail(name, email);
    }
}
