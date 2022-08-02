package com.mystore.mystoreapidev;

import com.mystore.mystoreapidev.domain.User;
import com.mystore.mystoreapidev.persistence.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MystoreApiDevApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void testMP(){
        System.out.println(userMapper);
        //打印它的哈希
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList.size());
    }

}
