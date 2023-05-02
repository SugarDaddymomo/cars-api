package com.ashutosh.carmanagementapi.controller;

import com.ashutosh.carmanagementapi.dto.CarDTO;
import com.ashutosh.carmanagementapi.requests.CreateCarRequest;
import com.ashutosh.carmanagementapi.requests.UpdateCarRequest;
import com.ashutosh.carmanagementapi.responses.CreateCarResponse;
import com.ashutosh.carmanagementapi.responses.DeleteCarResponse;
import com.ashutosh.carmanagementapi.responses.GetCarResponse;
import com.ashutosh.carmanagementapi.responses.UpdateCarResponse;
import com.ashutosh.carmanagementapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car-api")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @PostMapping("/add-car")
    public ResponseEntity<CreateCarResponse> addCar(@RequestBody @Valid CreateCarRequest request) {
        return ResponseEntity.ok(service.createCar(request));
    }

    @GetMapping("/fetch-car/{id}")
    public ResponseEntity<GetCarResponse> getCarById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getCar(id));
    }

    @GetMapping("/fetch-cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }

    @DeleteMapping("/delete-car/{id}")
    public ResponseEntity<DeleteCarResponse> deleteCar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deleteCar(id));
    }

    @PutMapping("/update-car/{id}")
    public ResponseEntity<UpdateCarResponse> updateCar(@PathVariable("id") Long id, @RequestBody @Valid UpdateCarRequest request) {
        return ResponseEntity.ok(service.updateCar(id, request));
    }
}