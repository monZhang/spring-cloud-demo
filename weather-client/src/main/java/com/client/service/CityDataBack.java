package com.client.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Feign的hystrix回调类
 */
@Component
public class CityDataBack implements FeignCityDataService {


    @Override
    public List<String> citys() {
        ArrayList<String> citys = new ArrayList<>();
        citys.add("feign service not available");
        return citys;
    }
}
