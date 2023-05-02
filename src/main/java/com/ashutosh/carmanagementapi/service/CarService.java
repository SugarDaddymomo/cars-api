package com.ashutosh.carmanagementapi.service;

import com.ashutosh.carmanagementapi.dto.CarDTO;
import com.ashutosh.carmanagementapi.requests.CreateCarRequest;
import com.ashutosh.carmanagementapi.requests.UpdateCarRequest;
import com.ashutosh.carmanagementapi.responses.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*
 * Service Interface to serve Car related logic
 */
public interface CarService {
    CreateCarResponse createCar(CreateCarRequest request);
    GetCarResponse getCar(Long id);
    DeleteCarResponse deleteCar(Long id);
    UpdateCarResponse updateCar(Long id, UpdateCarRequest request);
    PaginatedResponse fetchAllCars(String name, Pageable pageable);
}
