package cloud.springframework.gurukursmsscbrewery.web.services;

import cloud.springframework.gurukursmsscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto save(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .upc(beerDto.getUpc())
                .beerStyle(beerDto.getBeerStyle())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDto beerDto) {
        log.debug("Updating beer with id: " + beerId.toString());
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting beer with id: " + beerId.toString());
    }
}
