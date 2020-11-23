package cloud.springframework.gurukursmsscbrewery.web.mappers;

import cloud.springframework.gurukursmsscbrewery.domain.Beer;
import cloud.springframework.gurukursmsscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
