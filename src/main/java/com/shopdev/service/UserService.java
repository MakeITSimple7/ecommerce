package com.shopdev.service;

import com.shopdev.entity.user.UserEntity;


public interface UserService {
    UserEntity createUser(UserEntity user);

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
}
