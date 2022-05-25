package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.mapper")
@SpringBootApplication
public class StaffEmployeeSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffEmployeeSystemApplication.class, args);
    }

}
