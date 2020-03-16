package org.javaboy.cacheredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheRedisApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void getUserById() {
        User user1 = userService.getUserById(1);
        User user2 = userService.getUserById(2);
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    void deleteUserById() {
        userService.deleteUserById(1);
    }

    @Test
    void updateUserById() {
        User user1 = userService.updateUserById(1);
        System.out.println(user1);
    }
}