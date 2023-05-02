package com.ashutosh.carmanagementapi.controller;

import com.ashutosh.carmanagementapi.dto.CarDTO;
import com.ashutosh.carmanagementapi.requests.CreateCarRequest;
import com.ashutosh.carmanagementapi.requests.UpdateCarRequest;
import com.ashutosh.carmanagementapi.responses.*;
import com.ashutosh.carmanagementapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<PaginatedResponse> getAllCars(@RequestParam("query") String query, Pageable pageable) {
        return ResponseEntity.ok(service.fetchAllCars(query, pageable));
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