package me.gogosing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by JinBum Jeong on 2020/02/22.
 */
@SpringBootApplication
@EnableEurekaClient
public class ApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationInitializer.class, args);
    }
}
