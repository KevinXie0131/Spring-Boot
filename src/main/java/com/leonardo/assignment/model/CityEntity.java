package com.leonardo.assignment.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CityEntity {
    @NotNull(message = "city id is mandatory")
    private Integer id;
    @NotBlank(message = "city name is mandatory")
    private String name;
    @NotNull(message = "latitude is mandatory")
    private Double latitude;
    @NotNull(message = "longitude is mandatory")
    private Double longitude;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String toString() {
        return "id:" + id + ", name:" + name + ", latitude:" + latitude + ", longitude:" + longitude;
    }
}
