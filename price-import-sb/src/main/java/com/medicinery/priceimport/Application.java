package com.medicinery.priceimport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("----------aaaaa");
//        System.exit(SpringApplication.exit(SpringApplication.run(BatchConfiguration.class, args)));
        SpringApplication.run(BatchConfiguration.class, args);
        System.out.println("----------bbbbb");
    }
}
