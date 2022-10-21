package com.studie.eindopdracht.garage.service;

import com.studie.eindopdracht.garage.dtos.CarDto;
import com.studie.eindopdracht.garage.exceptions.RecordNotFoundException;
import com.studie.eindopdracht.garage.models.Car;
import com.studie.eindopdracht.garage.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDto> getAllCars() {
        List<Car> carList = carRepository.findAll();
        List<CarDto> carDtoList = new ArrayList<>();

        for(Car car : carList) {
            CarDto dto = transferToDto(car);
            carDtoList.add(dto);
        }
        return carDtoList;
    }

    public CarDto getCarById(Long id) {

        if(carRepository.findById(id).isPresent()){
            Car dto = carRepository.findById(id).get();
            return transferToDto(dto);
        } else {
            throw new RecordNotFoundException("geen auto gevonden");
        }
    }

    private CarDto transferToDto(Car car) {
        CarDto dto = new CarDto();

        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setType(car.getType());

        return dto;
    }



    public Long createCar(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand);
        car.setType(carDto.type);

        Car savedCar = this.carRepository.save(car);

        return savedCar.getId();
    }
}
