package com.example.fe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration; // 追加

// (exclude = {DataSourceAutoConfiguration.class}) を追加
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeApplication.class, args);
    }
}