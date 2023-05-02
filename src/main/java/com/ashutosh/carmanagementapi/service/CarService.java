package com.ashutosh.carmanagementapi.service;

import com.ashutosh.carmanagementapi.dto.CarDTO;
import com.ashutosh.carmanagementapi.requests.CreateCarRequest;
import com.ashutosh.carmanagementapi.requests.UpdateCarRequest;
import com.ashutosh.carmanagementapi.responses.CreateCarResponse;
import com.ashutosh.carmanagementapi.responses.DeleteCarResponse;
import com.ashutosh.carmanagementapi.responses.GetCarResponse;
import com.ashutosh.carmanagementapi.responses.UpdateCarResponse;

import java.util.List;

public interface CarService {
    CreateCarResponse createCar(CreateCarRequest request);

    GetCarResponse getCar(Long id);

    List<CarDTO> getAllCars();

    DeleteCarResponse deleteCar(Long id);

    UpdateCarResponse updateCar(Long id, UpdateCarRequest request);
}
