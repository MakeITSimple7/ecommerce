package com.shopdev.service;

import com.shopdev.entity.user.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);

    List<UserEntity> getAllUsers();
}
