package com.mexbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="com.mexbo.mapper")
public class SpringbootMuxinBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMuxinBackendApplication.class, args);
    }
}
