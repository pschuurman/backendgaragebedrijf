package com.studie.eindopdracht.garage.service;

import com.studie.eindopdracht.garage.dtos.CarDto;
import com.studie.eindopdracht.garage.models.Car;
import com.studie.eindopdracht.garage.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Long createCar(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand);
        car.setType(carDto.type);

        Car savedCar = this.carRepository.save(car);

        return savedCar.getId();
    }
}
