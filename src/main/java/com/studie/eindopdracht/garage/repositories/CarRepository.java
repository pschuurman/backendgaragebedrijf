package com.studie.eindopdracht.garage.repositories;

import com.studie.eindopdracht.garage.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
