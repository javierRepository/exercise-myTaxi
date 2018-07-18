package com.mytaxi.controller;


import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.driver.CarService;
import com.mytaxi.domainvalue.EngineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/cars")
public class CarController {


    private final CarService carService;


    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/{carId}")
    public CarDTO getCar(@Valid @PathVariable long carId) throws EntityNotFoundException {
        return CarMapper.makeCarDTO(carService.find(carId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException {
        CarDO carDO = CarMapper.makeCarDO(carDTO);
        return CarMapper.makeCarDTO(carService.create(carDO));
    }


    @DeleteMapping("/{carId}")
    public void deleteCar(@Valid @PathVariable long carId) throws EntityNotFoundException {
        carService.delete(carId);
    }


        @PutMapping("/{driverId}")
        public void updateCarInfo(
                @Valid @PathVariable long carId, String licencePlate, Integer seatCount, Integer rating, Boolean convertible, Enum<EngineType> engineType)
                throws ConstraintsViolationException, EntityNotFoundException {
            carService.updateCarInfo(carId,licencePlate,seatCount,rating,convertible,engineType);
        }

}
