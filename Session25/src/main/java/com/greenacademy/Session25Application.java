package com.greenacademy;

import com.greenacademy.config.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Session25Application implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(jwtUtils.getExpiration());
    }

    @Autowired
    private JwtUtils jwtUtils;

    public static void main(String[] args) {
        SpringApplication.run(Session25Application.class, args);
    }

}
