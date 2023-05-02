package com.ashutosh.carmanagementapi.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    private String brand;
    private String model;
    private boolean is4wd;
    private boolean isManual;
}
