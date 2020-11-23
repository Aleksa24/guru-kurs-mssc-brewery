package cloud.springframework.gurukursmsscbrewery.web.controller.v2;

import cloud.springframework.gurukursmsscbrewery.web.model.BeerDto;
import cloud.springframework.gurukursmsscbrewery.web.model.v2.BeerDtoV2;
import cloud.springframework.gurukursmsscbrewery.web.services.BeerService;
import cloud.springframework.gurukursmsscbrewery.web.services.v2.BeerServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v2/beer")
@Slf4j
@RequiredArgsConstructor
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){
        return new ResponseEntity(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDto){
        val savedBeerDto = beerService.save(beerDto);

        val httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","http://localhost:8080/api/v2/beer" + savedBeerDto.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@Valid @RequestBody BeerDtoV2 beerDto, @PathVariable("beerId") UUID beerId){
        beerService.update(beerId,beerDto);

        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }


}
