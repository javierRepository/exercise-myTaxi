package com.mytaxi.controller;


import com.mytaxi.controller.mapper.DriverMapper;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

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
        return DriverMapper.makeDriverDTO(carService.find(carId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCarr(@Valid @RequestBody DriverDTO driverDTO) throws ConstraintsViolationException {
        DriverDO driverDO = DriverMapper.makeDriverDO(driverDTO);
        return DriverMapper.makeDriverDTO(carService.create(driverDO));
    }


    @DeleteMapping("/{carId}")
    public void deleteCar(@Valid @PathVariable long carId) throws EntityNotFoundException {
        carService.delete(driverId);
    }


//        @PutMapping("/{driverId}")
//        public void updateLocation(
//                @Valid @PathVariable long driverId, @RequestParam double longitude, @RequestParam double latitude)
//                throws ConstraintsViolationException, EntityNotFoundException {
//            carService.updateLocation(driverId, longitude, latitude);
//        }
//
//
//        @GetMapping
//        public List<DriverDTO> findDrivers(@RequestParam OnlineStatus onlineStatus)
//                throws ConstraintsViolationException, EntityNotFoundException {
//            return DriverMapper.makeDriverDTOList(carService.find(onlineStatus));
//        }
}
