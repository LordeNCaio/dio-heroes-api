package com.caiomacedo.illegalityleague.controllers;

import com.caiomacedo.illegalityleague.constants.HeroesConstants;
import com.caiomacedo.illegalityleague.entities.Heroes;
import com.caiomacedo.illegalityleague.repositories.HeroesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;

import java.util.Collections;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesControllerTests {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    HeroesRepository heroesRepository;

    @Test
    public void getHeroesById(){
        webTestClient.get().uri(HeroesConstants.HEROES_LOCAL_ENDPOINT.concat("/{id}"), 1)
                .exchange()
                .expectStatus().isFound()
                .expectBody();
    }

    @Test
    public void deleteHeroesById(){
        webTestClient.delete().uri(HeroesConstants.HEROES_LOCAL_ENDPOINT.concat("/{id}"), 3)
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    public void saveHero(){
        webTestClient.post().uri(HeroesConstants.HEROES_LOCAL_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(createHero()))
                .exchange()
                .expectStatus().isCreated();
    }

    public Heroes createHero(){
        return new Heroes(heroesCount().toString(), "Irineu", "Darvel", 50);
    }

    private Integer heroesCount(){
        Integer count = 0;
        var heroes = heroesRepository.findAll();

        for(var hero : heroes){
            count++;
        }
        return count+1;
    }
}
