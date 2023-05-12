package com.ashutosh.carmanagementapi.controller;

import com.ashutosh.carmanagementapi.requests.ReclaimRequest;
import com.ashutosh.carmanagementapi.responses.ReclaimResponse;
import com.ashutosh.carmanagementapi.service.ReclaimNumberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/sonetel/reclaim")
public class ReclaimController {

    private final ReclaimNumberService service;


    @DeleteMapping(value = "/reclaimphonenumber/{did}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReclaimResponse> deleteNumber(
            @RequestBody ReclaimRequest reclaimRequest,
            HttpServletRequest request,
            @PathVariable("did") String did
    ) {
        String country = request.getHeader("Country");
        String connection = request.getHeader("Connection");
        log.info(country +" "+ connection);
        return service.deleteNumber(reclaimRequest);
    }

}