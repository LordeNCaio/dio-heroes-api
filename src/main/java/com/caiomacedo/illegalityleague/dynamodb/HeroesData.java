package com.caiomacedo.illegalityleague.dynamodb;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;

import com.caiomacedo.illegalityleague.constants.HeroesConstants;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class HeroesData {

    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        HeroesConstants.DYNAMO_ENDPOINT,
                        HeroesConstants.DYNAMO_REGION)
                )
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("heroes");
        Item _hero = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Miserable Man")
                .withString("universe", "CC Comics")
                .withNumber("films", 2);

        PutItemOutcome out = table.putItem(_hero);

    }

}
