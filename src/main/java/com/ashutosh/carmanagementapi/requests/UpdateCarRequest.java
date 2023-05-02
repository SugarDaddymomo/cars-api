package com.ashutosh.carmanagementapi.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private String brand;
    private String model;
    private boolean is4wd;
    private boolean isManual;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isIs4wd() {
        return is4wd;
    }

    public void setIs4wd(boolean is4wd) {
        this.is4wd = is4wd;
    }

    public boolean getIsManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }
}
