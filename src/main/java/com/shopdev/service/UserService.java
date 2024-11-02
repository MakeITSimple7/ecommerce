package com.shopdev.service;

import com.shopdev.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    UserEntity createUser(UserEntity user);

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    //get all by limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);

    // get search by limit offset
    Page<UserEntity> findByUserName(String userName, Pageable pageble);
}
