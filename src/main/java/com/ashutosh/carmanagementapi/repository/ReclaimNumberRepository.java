package com.ashutosh.carmanagementapi.repository;

import com.ashutosh.carmanagementapi.model.ReclaimNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclaimNumberRepository extends JpaRepository<ReclaimNumber, Long> {

    void deleteByDid(String did);
}