package cloud.springframework.gurukursmsscbrewery.web.controller;

import cloud.springframework.gurukursmsscbrewery.web.model.BeerDto;
import cloud.springframework.gurukursmsscbrewery.web.model.CustomerDto;
import cloud.springframework.gurukursmsscbrewery.web.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"{customerId}"})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID beerId){
        return new ResponseEntity<>(customerService.getCustomerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity handlePost(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto savedCustomerDto = customerService.save(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/v1/customer/" + savedCustomerDto.getId().toString());

        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity handleUpdate(@Valid @RequestBody CustomerDto customerDto,@PathVariable("customerId") UUID customerId){
        customerService.update(customerId,customerDto);

        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
    }


}
