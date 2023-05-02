package com.ashutosh.carmanagementapi.responses;

import com.ashutosh.carmanagementapi.dto.CarDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginatedResponse {
    private List<CarDTO> list;
    private long numberOfItems;
    private int numberOfPages;
}