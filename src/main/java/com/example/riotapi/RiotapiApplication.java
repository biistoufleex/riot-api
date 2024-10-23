package com.example.riotapi;

import com.example.riotapi.configuration.RiotApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RiotApiProperties.class)
public class RiotapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiotapiApplication.class, args);
    }

}
