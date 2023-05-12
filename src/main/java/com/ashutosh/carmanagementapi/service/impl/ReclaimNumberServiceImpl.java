package com.ashutosh.carmanagementapi.service.impl;

import com.ashutosh.carmanagementapi.ReclaimStatus;
import com.ashutosh.carmanagementapi.model.ReclaimNumber;
import com.ashutosh.carmanagementapi.repository.ReclaimNumberRepository;
import com.ashutosh.carmanagementapi.requests.ReclaimRequest;
import com.ashutosh.carmanagementapi.responses.ReclaimResponse;
import com.ashutosh.carmanagementapi.service.ReclaimNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReclaimNumberServiceImpl implements ReclaimNumberService {

    private final ReclaimNumberRepository repository;

    @Value("${project.api.url}")
    private String apiURL;

    @Override
    public ResponseEntity<ReclaimResponse> deleteNumber(ReclaimRequest request) {
        ReclaimResponse response = new ReclaimResponse();
        if (Objects.nonNull(request) && StringUtils.isEmpty(request.getDid()) && StringUtils.isEmpty(request.getProviderName())) {
            if (request.getProviderName().equalsIgnoreCase("DIDWW")) {
                repository.deleteByDid(request.getDid());
            } else if (request.getProviderName().equalsIgnoreCase("Voxbone")) {
                repository.deleteByDid(request.getDid());
            }
//            return new ResponseEntity<>(response, HttpStatus.OK);
            response.setStatus(ReclaimStatus.SUCCESS.toString());
            response.setStatusCode(HttpStatus.OK.value());
            response.setStatusDesc("OK");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.setStatusDesc("Please provide request in proper format!");
            response.setStatus(ReclaimStatus.FAILED.toString());
            response.setStatusCode(HttpStatus.NO_CONTENT.value());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
