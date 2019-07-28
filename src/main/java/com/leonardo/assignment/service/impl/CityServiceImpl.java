package com.leonardo.assignment.service.impl;

import com.leonardo.assignment.dao.CityDAO;
import com.leonardo.assignment.model.CityEntity;
import com.leonardo.assignment.service.ICityService;
import com.leonardo.assignment.utils.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDAO cityDao;

    @Override
    public CityEntity findByCityId(Integer cityId) {
        return cityDao.findById(cityId) ;
    }

    @Override
    public void deleteByCityId(Integer cityId){
        logger.info("Delete City with Id：" + cityId);
        cityDao.deleteById(cityId);
    }

    @Override
    public Integer createCity(CityEntity city){
        logger.info("Create City with Id：" + city.getId());
        return cityDao.create(city);
    }

    @Override
    public void updateCity(CityEntity updatedCity){
        logger.info("Update City with Id：" + updatedCity.getId());
        cityDao.update(updatedCity);
    }

    @Override
    public List<CityEntity> listAllCities(){
        return cityDao.listAll();
    }

    @Override
    public double getDistance(Integer cityId1, Integer cityId2){
        CityEntity city1 = findByCityId(cityId1);
        CityEntity city2 = findByCityId(cityId2);
        if(city1 == null || city2 == null){
            throw new NullPointerException("Cannot find the city to calculate the distance");
        }
        return Location.getDistance(city1.getLatitude(), city1.getLongitude(), city2.getLatitude(), city2.getLongitude());
    }
}
