package com.ashutosh.carmanagementapi.responses;

import com.ashutosh.carmanagementapi.dto.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCarResponse {
    private CarDTO car;
    private String message;
}
