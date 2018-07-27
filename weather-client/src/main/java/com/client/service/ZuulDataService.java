package com.client.service;

import com.client.entity.ResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "zuul-gateway")
public interface ZuulDataService {

    @GetMapping("/citys")
    List<String> citys();

    @GetMapping("/weather/{city}")
    ResponseBody wDetail(@PathVariable("city") String city);

}
