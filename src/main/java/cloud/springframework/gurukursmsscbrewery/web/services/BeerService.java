package cloud.springframework.gurukursmsscbrewery.web.services;

import cloud.springframework.gurukursmsscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto save(BeerDto beerDto);

    void update(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
