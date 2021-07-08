package com.sram.buct_production_practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@MapperScan
@SpringBootApplication
public class BuctProductionPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuctProductionPracticeApplication.class, args);
    }

}
