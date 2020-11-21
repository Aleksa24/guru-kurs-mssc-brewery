package cloud.springframework.gurukursmsscbrewery.web.services.v2;

import cloud.springframework.gurukursmsscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public Object getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 save(BeerDtoV2 beerDto) {
        return null;
    }

    @Override
    public void update(UUID beerId, BeerDtoV2 beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
