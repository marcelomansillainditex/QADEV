package com.qadev.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qadev.automation")
class Main {
    static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
