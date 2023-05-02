package com.ashutosh.carmanagementapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private String brand;
    private String model;
    private boolean is4wd;
    private boolean isManual;
}
