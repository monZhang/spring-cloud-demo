package com.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "city-data")
public interface FeignCityDataService {

    @GetMapping("/citys")
    List<String> citys();


}
