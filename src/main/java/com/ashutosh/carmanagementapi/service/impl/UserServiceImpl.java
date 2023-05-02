package com.ashutosh.carmanagementapi.service.impl;

import com.ashutosh.carmanagementapi.model.Role;
import com.ashutosh.carmanagementapi.model.User;
import com.ashutosh.carmanagementapi.repository.UserRepository;
import com.ashutosh.carmanagementapi.requests.AuthenticationRequest;
import com.ashutosh.carmanagementapi.requests.RegisterRequest;
import com.ashutosh.carmanagementapi.responses.AuthenticationResponse;
import com.ashutosh.carmanagementapi.security.JwtService;
import com.ashutosh.carmanagementapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * Service Interface Implementation that provides User related logic implementations
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /*
    * Method that registers a user
    */
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        // saving user to DB
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    /*
     * Method that authenticates a user
     */
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        // check if a user exists with provided email and password
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
