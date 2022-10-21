package com.studie.eindopdracht.garage.controllers;


import com.studie.eindopdracht.garage.dtos.CustomerDto;
import com.studie.eindopdracht.garage.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService;}

    @PostMapping("/customers")
    public ResponseEntity<Long> createCustomer(@RequestBody CustomerDto customerDto) {
        Long customerId = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerId, HttpStatus.CREATED);

    }
}
