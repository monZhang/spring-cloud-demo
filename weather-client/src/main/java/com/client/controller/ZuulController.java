package com.client.controller;

import com.client.entity.ResponseBody;
import com.client.service.ZuulDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * zuul 网关方式调用
 */

@RestController
public class ZuulController {

    @Autowired
    private ZuulDataService zuulDataService;

    @GetMapping("/z/citys")
    public List<String> citys() {
        return zuulDataService.citys();
    }

    @GetMapping("/z/{city}")
    public ResponseBody weatherDetail(@PathVariable String city) {
        return zuulDataService.wDetail(city);
    }

}
