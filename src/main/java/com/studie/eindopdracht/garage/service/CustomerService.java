package com.studie.eindopdracht.garage.service;

import com.studie.eindopdracht.garage.dtos.CustomerDto;
import com.studie.eindopdracht.garage.models.Customer;
import com.studie.eindopdracht.garage.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Long createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.firstName);
        customer.setLastName(customerDto.lastName);
        customer.setStreet(customerDto.street);
        customer.setPostalCode(customerDto.postalCode);
        customer.setHouseNumber(customerDto.houseNumber);

        Customer savedCustomer = this.customerRepository.save(customer);

        return savedCustomer.getId();
    }
}

