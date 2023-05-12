package com.ashutosh.carmanagementapi.model;

import com.ashutosh.carmanagementapi.ReclaimStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reclaim_numbers")
public class ReclaimNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String did;
    private String providerName;
    private ReclaimStatus status;
    private String statusCode;
    private String statusDesc;
}