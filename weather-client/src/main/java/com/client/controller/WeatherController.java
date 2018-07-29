package com.client.controller;

import com.client.entity.ResponseBody;
import com.client.service.CityDataService;
import com.client.service.WeatherDataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * httpClient 调用
 */

@RestController
public class WeatherController {

    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/w/citys")
    @HystrixCommand(fallbackMethod = "cityBack")   //Feign 实现Hystrix 方式一
    public List<String> citys() {
        return cityDataService.citys();
    }

    @GetMapping("/w/{city}")
    public ResponseBody weatherDetail(@PathVariable String city) {
        return weatherDataService.weatherDetail(city);
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/detail")
    private String instanceDetail() {
        final int port = loadBalancerClient.choose("city-data1").getPort();
        return String.valueOf(port);
    }

    private List<String> cityBack() {
        final ArrayList<String> citys = new ArrayList<>();
        citys.add("服务不可用");
        return citys;
    }



}
