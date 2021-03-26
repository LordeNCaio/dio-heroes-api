package com.caiomacedo.illegalityleague.services;

import com.caiomacedo.illegalityleague.entities.Heroes;
import com.caiomacedo.illegalityleague.exceptions.HeroNotFoundException;
import com.caiomacedo.illegalityleague.repositories.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    public Flux<Heroes> findAll(){
        return Flux.fromIterable(heroesRepository.findAll());
    }

    public Mono<Heroes> findById(String id){
        return Mono.justOrEmpty(heroesRepository.findById(id).orElseThrow(HeroNotFoundException::new));
    }

    public Mono<Heroes> saveHero(Heroes hero){
        return Mono.justOrEmpty(heroesRepository.save(hero));
    }

    public Mono<Boolean> deleteById(String id){
        heroesRepository.deleteById(id);
        return Mono.just(heroesRepository.existsById(id));
    }
}
