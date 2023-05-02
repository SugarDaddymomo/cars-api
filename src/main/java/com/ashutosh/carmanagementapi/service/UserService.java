package com.ashutosh.carmanagementapi.service;

import com.ashutosh.carmanagementapi.requests.AuthenticationRequest;
import com.ashutosh.carmanagementapi.requests.RegisterRequest;
import com.ashutosh.carmanagementapi.responses.AuthenticationResponse;

/*
* Service Interface to serve User related logic
*/
public interface UserService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
