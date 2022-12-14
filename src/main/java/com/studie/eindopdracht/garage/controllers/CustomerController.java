package com.studie.eindopdracht.garage.controllers;

import com.studie.eindopdracht.garage.dtos.CustomerDto;
import com.studie.eindopdracht.garage.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService;}

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(@RequestParam(value = "firstName", required = false) Optional<String> firstName) {
        List<CustomerDto> customerDtoList;
        customerDtoList = customerService.getAllCustomers();

        return ResponseEntity.ok().body(customerDtoList);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id")Long id) {

        CustomerDto customer = customerService.getCustomerById(id);

        return ResponseEntity.ok().body(customer);

    }

    @PostMapping("/customers")
    public ResponseEntity<Long> createCustomer(@RequestBody CustomerDto customerDto) {
        Long customerId = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerId, HttpStatus.CREATED);

    }
}
