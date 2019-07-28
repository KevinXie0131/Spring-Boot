package com.leonardo.assignment.controller;

import com.leonardo.assignment.model.CityEntity;
import com.leonardo.assignment.service.ICityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.leonardo.assignment.utils.ResultJson;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cities")
@Api(value = "City CRUD")
public class CityController
{
    @Value("${deleteSuccMessage}")
    private String deleteSuccMessage;

    @Value("${createSuccMessage}")
    private String createSuccMessage;

    @Value("${updateSuccMessage}")
    private String updateSuccMessage;

    @Value("${noCityFoundMessage}")
    private String noCityFoundMessage;

    @Autowired
    private ICityService iCityService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping()
    private ResponseEntity listAllCities(){
        List<CityEntity> cityList = iCityService.listAllCities();
        return new ResponseEntity<>(iCityService.listAllCities(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    private ResponseEntity findByCityId(@PathVariable("id") String cityId){
        CityEntity city = iCityService.findByCityId(Integer.parseInt(cityId));
        if (city == null) {
            return new ResponseEntity<>(new ResultJson(5, noCityFoundMessage, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity deleteByCityId(@PathVariable("id") String cityId){
        iCityService.deleteByCityId(Integer.parseInt(cityId));
        return new ResponseEntity<>(new ResultJson(3, deleteSuccMessage, null), HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity createCity(@Valid @RequestBody CityEntity city){
        iCityService.createCity(city);
        return new ResponseEntity<>(new ResultJson(1, createSuccMessage,null), HttpStatus.OK);
    }

    @PutMapping()
    private ResponseEntity updateCity(@Valid @RequestBody CityEntity city){
        iCityService.updateCity(city);
        return new ResponseEntity<>(new ResultJson(2, updateSuccMessage, null), HttpStatus.OK);
    }

    @GetMapping(value = "distance")
    private ResponseEntity getDistance(@RequestParam(required = true) String cityId1, @RequestParam(required = true) String cityId2){
        double distance = iCityService.getDistance(Integer.parseInt(cityId1), Integer.parseInt(cityId2));
        return new ResponseEntity<>(new ResultJson(4, String.valueOf(distance) + " KM", null), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping(value = "/test")
    public String testRestTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://localhost:8080/cities/1", HttpMethod.GET, entity, String.class).getBody();
    }
}
