package com.client.service;

import com.client.entity.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseBody weatherDetail(String city) {
        ResponseEntity<ResponseBody> forEntity = restTemplate.getForEntity("http://weather-data/weather/" + city, ResponseBody.class);
        ResponseBody body = forEntity.getBody();
        return body;
    }


}
