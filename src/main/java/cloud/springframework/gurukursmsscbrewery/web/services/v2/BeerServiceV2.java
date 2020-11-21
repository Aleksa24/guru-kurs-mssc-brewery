package cloud.springframework.gurukursmsscbrewery.web.services.v2;

import cloud.springframework.gurukursmsscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    Object getBeerById(UUID beerId);

    BeerDtoV2 save(BeerDtoV2 beerDto);

    void update(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
