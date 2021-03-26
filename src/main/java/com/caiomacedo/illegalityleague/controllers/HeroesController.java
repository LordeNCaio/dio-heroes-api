package com.caiomacedo.illegalityleague.controllers;

import com.caiomacedo.illegalityleague.constants.HeroesConstants;
import com.caiomacedo.illegalityleague.entities.Heroes;
import com.caiomacedo.illegalityleague.services.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping(HeroesConstants.HEROES_LOCAL_ENDPOINT)
public class HeroesController {

    public static final Logger log = LoggerFactory.getLogger(HeroesController.class);

    private final HeroesService heroesService;

    public HeroesController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public Flux<Heroes> findAll() {
        return heroesService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<Heroes> findById(@PathVariable String id) {
        return heroesService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> addHero(@RequestBody Heroes hero) {
        return heroesService.saveHero(hero);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Boolean> deleteHero(@PathVariable String id) {
        return heroesService.deleteById(id);
    }

}
