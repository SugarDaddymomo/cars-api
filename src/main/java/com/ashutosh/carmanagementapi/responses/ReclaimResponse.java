package com.ashutosh.carmanagementapi.responses;

import lombok.Data;

@Data
public class ReclaimResponse {
    private String status;
    private Integer statusCode;
    private String statusDesc;
}