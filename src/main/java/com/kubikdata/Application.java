package com.kubikdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.kubikdata.configuration", "com.kubikdata.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
