package com.leonardo.assignment.dao;

import java.util.List;
import java.util.Random;

import com.leonardo.assignment.model.CityEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CityDAO {

    private final CityDatabase cityDatabase;

    public CityDAO() {
        this.cityDatabase = CityDatabase.getInstance();
    }

    public CityEntity findById(Integer id) {
        for(CityEntity city : cityDatabase.getCityList()) {
            if(city.getId().equals(id)) {
                return city;
            }
        }
        return null;
    }

    public void deleteById(Integer id) {
        CityEntity city = this.findById(id);
        if(city == null){
            throw new NullPointerException("Cannot find the city(id=" + id + ") to delete");
        }
        cityDatabase.getCityList().remove(city);
    }

    public List<CityEntity> listAll() {
        return cityDatabase.getCityList();
    }

    public Integer create(CityEntity city) {
        Random random = new Random();
        Integer id = java.lang.Math.abs(random.nextInt());

        city.setId(id);
        cityDatabase.getCityList().add(city);

        return id;
    }

    public CityEntity update(CityEntity updatedCity) {
        CityEntity city = this.findById(updatedCity.getId());

        if(city == null) {
            throw new NullPointerException("Cannot find the city(id=" + updatedCity.getId() + ") to update");
        }

        city.setName(updatedCity.getName());
        city.setLatitude(updatedCity.getLatitude());
        city.setLongitude(updatedCity.getLongitude());
        return city;
    }
}
