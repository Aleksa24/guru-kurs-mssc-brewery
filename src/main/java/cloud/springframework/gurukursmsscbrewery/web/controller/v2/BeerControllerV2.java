package cloud.springframework.gurukursmsscbrewery.web.controller.v2;

import cloud.springframework.gurukursmsscbrewery.web.model.BeerDto;
import cloud.springframework.gurukursmsscbrewery.web.model.v2.BeerDtoV2;
import cloud.springframework.gurukursmsscbrewery.web.services.BeerService;
import cloud.springframework.gurukursmsscbrewery.web.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto){
        BeerDtoV2 savedBeerDto = beerService.save(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","http://localhost:8080/api/v2/beer" + savedBeerDto.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@RequestBody BeerDtoV2 beerDto, @PathVariable("beerId") UUID beerId){
        beerService.update(beerId,beerDto);

        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}
