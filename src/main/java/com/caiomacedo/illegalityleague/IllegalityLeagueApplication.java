package com.caiomacedo.illegalityleague;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class IllegalityLeagueApplication {

    public static void main(String[] args) {
        SpringApplication.run(IllegalityLeagueApplication.class, args);
    }

}
