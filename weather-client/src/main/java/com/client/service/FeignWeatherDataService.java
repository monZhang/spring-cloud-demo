package com.client.service;

import com.client.entity.ResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "weather-data")
public interface FeignWeatherDataService {

    @GetMapping("/weather/{city}")
    ResponseBody wDetail(@PathVariable("city") String city);
}
