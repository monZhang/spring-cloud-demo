package com.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "city-data", fallback = CityDataBack.class)//指定失败回调类
public interface FeignCityDataService {

    @GetMapping("/citys")
    List<String> citys();


}
