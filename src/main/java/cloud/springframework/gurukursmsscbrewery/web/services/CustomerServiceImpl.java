package cloud.springframework.gurukursmsscbrewery.web.services;

import cloud.springframework.gurukursmsscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Customer Name")
                .build();
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Customer Name")
                .build();
    }

    @Override
    public void update(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating customer with id: " + customerId);
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleted customer with id: " + customerId);
    }
}
