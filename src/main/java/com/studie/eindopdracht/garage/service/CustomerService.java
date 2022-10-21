package com.studie.eindopdracht.garage.service;

import com.studie.eindopdracht.garage.dtos.CustomerDto;
import com.studie.eindopdracht.garage.exceptions.RecordNotFoundException;
import com.studie.eindopdracht.garage.models.Customer;
import com.studie.eindopdracht.garage.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer customer : customerList) {
            CustomerDto dto = transferToDto(customer);
            customerDtoList.add(dto);
        }
        return customerDtoList;
    }

    public CustomerDto getCustomerById(Long id) {

        if (customerRepository.findById(id).isPresent()){
            Customer dto = customerRepository.findById(id).get();
            return transferToDto(dto);
        } else {
            throw new RecordNotFoundException("geen klant gevonden");
        }
    }

    private CustomerDto transferToDto(Customer customer) {
        CustomerDto dto = new CustomerDto();

        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setStreet(customer.getStreet());
        dto.setHouseNumber(customer.getHouseNumber());
        dto.setPostalCode(customer.getPostalCode());

        return dto;
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

