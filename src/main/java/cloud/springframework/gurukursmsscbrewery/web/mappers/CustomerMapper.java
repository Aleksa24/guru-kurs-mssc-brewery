package cloud.springframework.gurukursmsscbrewery.web.mappers;

import cloud.springframework.gurukursmsscbrewery.domain.Customer;
import cloud.springframework.gurukursmsscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

}
