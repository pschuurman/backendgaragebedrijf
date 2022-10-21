package com.studie.eindopdracht.garage.repositories;

import com.studie.eindopdracht.garage.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
