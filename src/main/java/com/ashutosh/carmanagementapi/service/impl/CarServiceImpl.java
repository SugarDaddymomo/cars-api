package com.ashutosh.carmanagementapi.service.impl;

import com.ashutosh.carmanagementapi.dto.CarDTO;
import com.ashutosh.carmanagementapi.model.Car;
import com.ashutosh.carmanagementapi.repository.CarRepository;
import com.ashutosh.carmanagementapi.requests.CreateCarRequest;
import com.ashutosh.carmanagementapi.requests.UpdateCarRequest;
import com.ashutosh.carmanagementapi.responses.CreateCarResponse;
import com.ashutosh.carmanagementapi.responses.DeleteCarResponse;
import com.ashutosh.carmanagementapi.responses.GetCarResponse;
import com.ashutosh.carmanagementapi.responses.UpdateCarResponse;
import com.ashutosh.carmanagementapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    private final static Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    @Override
    public CreateCarResponse createCar(CreateCarRequest request) {
        CreateCarResponse response = new CreateCarResponse();
        if (Objects.nonNull(request) && Objects.nonNull(request.getBrand()) && Objects.nonNull(request.getModel())) {
            // Empty brand and model passed
            if (StringUtils.isEmpty(request.getBrand()) && StringUtils.isEmpty(request.getModel())) {
                LOGGER.info("brand and model not passed!");
                response.setMessage("Brand and Model are required attributes, they cannot be null or empty.");
                return response;
            }
            // brand and model are not empty
            var car = Car.builder()
                    .brand(request.getBrand())
                    .model(request.getModel())
                    .is4wd(request.is4wd())
                    .isManual(request.isManual())
                    .build();
            try {
                LOGGER.info("Trying to save Car into DB {}", car.toString());
                repository.save(car);
                response.setMessage(String.format("Car saved with model %s and brand %s.", request.getModel(), request.getBrand()));
            } catch (Exception e) {
                LOGGER.error("Exception encountered {}", e.getLocalizedMessage());
                response.setMessage("Duplicate model saving isn't allowed");
            }
            return response;
        }
        // request was not passed in required format
        response.setMessage("Please provide proper request");
        return response;
    }

    @Override
    public GetCarResponse getCar(Long id) {
        GetCarResponse response = new GetCarResponse();
        var car = repository.findById(id);
        if (!car.isPresent()) {
            response.setMessage(String.format("No Car was found with this id %d", id));
            return response;
        }
        response.setCar(
                CarDTO.builder()
                        .brand(car.get().getBrand())
                        .model(car.get().getModel())
                        .is4wd(car.get().is4wd())
                        .isManual(car.get().isManual())
                        .build()
        );
        response.setMessage(String.format("Car is available with this id %d", id));
        return response;
    }

    @Override
    public List<CarDTO> getAllCars() {
        var cars = repository.findAll();
        return cars.stream()
                .map(
                        car -> new CarDTO(car.getBrand(), car.getModel(), car.is4wd(), car.isManual())
                ).
                toList();
    }

    @Override
    public DeleteCarResponse deleteCar(Long id) {
        DeleteCarResponse response = new DeleteCarResponse();
        var car = repository.findById(id);
        if (!car.isPresent()) {
            response.setMessage(String.format("No car exists with this id %d", id));
            return response;
        }
        repository.deleteById(id);
        response.setMessage(String.format("Car deleted with id %d", id));
        return response;
    }

    @Override
    public UpdateCarResponse updateCar(Long id, UpdateCarRequest request) {
        UpdateCarResponse response = new UpdateCarResponse();
        var car = repository.findById(id);
        if (!car.isPresent()) {
            LOGGER.info("no car found with id {}", id);
            response.setMessage(String.format("No car was found with this id %d", id));
            return response;
        }
        car.get().setBrand(request.getBrand());
        car.get().setModel(request.getModel());
        car.get().set4wd(request.isIs4wd());
        car.get().setManual(request.getIsManual());
        LOGGER.info("trying to save updated car to db {}", car.get());
        repository.save(car.get());
        response.setMessage(String.format("Updated car with id %d", id));
        return response;
    }
}
