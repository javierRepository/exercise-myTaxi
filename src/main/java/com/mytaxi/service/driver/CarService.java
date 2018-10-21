package com.mytaxi.service.driver;


import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.util.EngineType;


public interface CarService {

    CarDO find(Long carId) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(Long carId) throws EntityNotFoundException;

    void updateCarInfo(long carId, String licencePlate, Integer seatCount, Integer rating, Boolean convertible, Enum<EngineType> engineType) throws EntityNotFoundException;
}
