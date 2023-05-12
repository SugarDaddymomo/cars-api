package com.ashutosh.carmanagementapi.service;

import com.ashutosh.carmanagementapi.requests.ReclaimRequest;
import com.ashutosh.carmanagementapi.responses.ReclaimResponse;
import org.springframework.http.ResponseEntity;

public interface ReclaimNumberService {
    ResponseEntity<ReclaimResponse> deleteNumber(ReclaimRequest reclaimRequest);
}
