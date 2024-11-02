package com.shopdev.shop_dev_java;

import com.shopdev.entity.feed.FeedEntity;
import com.shopdev.entity.user.UserEntity;
import com.shopdev.repository.FeedRepository;
import com.shopdev.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void oneToManyTest() {
        // 1. New User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("AVC");
        user.setUserEmail("abc@gmail.com");

        feed.setTitle("Feed 01");
        user.setFeedList(List.of(feed));
        feed.setUser(user);
        userRepository.save(user);
        feedRepository.save(feed);
    }
}
