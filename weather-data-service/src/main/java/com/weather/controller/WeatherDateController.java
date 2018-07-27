package com.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.entity.ResponseBody;
import com.weather.entity.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class WeatherDateController {

    @Autowired
    private RestTemplate restTemplate;
    ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/weather/{city}")
    public ResponseBody getWeatherByCity(@PathVariable String city) throws IOException {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://wthrcdn.etouch.cn/weather_mini?city=" + city, String.class);
        String resultStr = StringUtil.conventFromGzip(forEntity.getBody());
        ResponseBody responseBody = objectMapper.readValue(resultStr, ResponseBody.class);
        return responseBody;
    }


}
