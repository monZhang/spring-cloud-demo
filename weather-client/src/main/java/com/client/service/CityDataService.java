package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CityDataService {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> citys() {
        ResponseEntity<List> forEntity = restTemplate.getForEntity("http://city-data1/citys", List.class);
        List<String> body = forEntity.getBody();
        return body;
    }

}
