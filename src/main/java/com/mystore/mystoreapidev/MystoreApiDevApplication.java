package com.mystore.mystoreapidev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mystore.mystoreapidev.persistence")
public class MystoreApiDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(MystoreApiDevApplication.class, args);
    }

}
