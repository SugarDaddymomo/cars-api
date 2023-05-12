package com.ashutosh.carmanagementapi.requests;

import lombok.Data;

@Data
public class ReclaimRequest {
    private String did;
    private String serviceId;
    private String providerName;
}