package com.caiomacedo.illegalityleague.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {

    @Value("http://localhost:8000")
    private String AMAZON_DYNAMODB_ENDPOINT;

    @Value("<empty>")
    private String AWS_ACCESS_KEY_ID;

    @Value("<empty>")
    private String AWS_SECRET_KEY;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials());
        if (!AMAZON_DYNAMODB_ENDPOINT.isEmpty()) {
            amazonDynamoDB.setEndpoint(AMAZON_DYNAMODB_ENDPOINT);
        }
        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials awsCredentials(){
        return new BasicAWSCredentials(
                AWS_ACCESS_KEY_ID,
                AWS_SECRET_KEY
        );
    }

}
