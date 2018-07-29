package com.client.controller;

import com.client.entity.ResponseBody;
import com.client.service.FeignCityDataService;
import com.client.service.FeignWeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Feign 方式调用
 */

@RestController
public class FeignWeatherController {
    @Autowired
    private FeignCityDataService feignCityDataService;
    @Autowired
    private FeignWeatherDataService weatherDataService;

    @GetMapping("/f/citys")
    public List<String> citys() {
        return feignCityDataService.citys();
    }

    @GetMapping("/f/{city}")
    public ResponseBody weatherDetail(@PathVariable String city) {
        return weatherDataService.wDetail(city);
    }

}
