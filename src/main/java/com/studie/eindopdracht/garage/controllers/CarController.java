package com.studie.eindopdracht.garage.controllers;

import com.studie.eindopdracht.garage.dtos.CarDto;
import com.studie.eindopdracht.garage.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) { this.carService = carService; }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars(@RequestParam(value = "brand", required = false)Optional<String> brand) {
        List<CarDto> carDtoList;
        carDtoList = carService.getAllCars();

        return ResponseEntity.ok().body(carDtoList);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable("id")Long id) {
        CarDto car = carService.getCarById(id);

        return ResponseEntity.ok().body(car);
    }


    @PostMapping("/cars")
    public ResponseEntity<Long> createCar(@RequestBody CarDto carDto) {
        Long carId = carService.createCar(carDto);
        return new ResponseEntity<>(carId, HttpStatus.CREATED);
    }
}
