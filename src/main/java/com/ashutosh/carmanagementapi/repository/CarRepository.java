package com.ashutosh.carmanagementapi.repository;

import com.ashutosh.carmanagementapi.model.Car;
import org.springframework.data.repository.ListCrudRepository;

public interface CarRepository extends ListCrudRepository<Car, Long> {

}