package com.ashutosh.carmanagementapi.repository;

import com.ashutosh.carmanagementapi.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
}