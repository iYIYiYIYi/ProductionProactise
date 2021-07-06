package com.sram.buct_production_practice;

import com.sram.buct_production_practice.controller.GetController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuctProductionPracticeApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BuctProductionPracticeApplication.class, args);
        GetController.getMethod();
    }

}
