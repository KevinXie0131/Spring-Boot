package com.leonardo.assignment.service;

import com.leonardo.assignment.model.CityEntity;
import java.util.List;

public interface ICityService {

    CityEntity findByCityId(Integer cityId);

    void deleteByCityId(Integer cityId);

    Integer createCity(CityEntity city);

    void updateCity(CityEntity updatedCity);

    List<CityEntity> listAllCities();

    double getDistance(Integer cityId1, Integer cityId2);

}
