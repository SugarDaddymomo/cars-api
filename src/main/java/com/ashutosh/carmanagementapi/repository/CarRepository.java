package com.ashutosh.carmanagementapi.repository;

import com.ashutosh.carmanagementapi.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findAllByBrandContains(String name, Pageable pageable);
}