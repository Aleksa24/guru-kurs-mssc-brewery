package cloud.springframework.gurukursmsscbrewery.web.services;

import cloud.springframework.gurukursmsscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);

    CustomerDto save(CustomerDto customerDto);

    void update(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);
}
