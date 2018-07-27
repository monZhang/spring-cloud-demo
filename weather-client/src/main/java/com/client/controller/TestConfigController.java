package com.client.controller;

import com.client.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-cloud-config 测试
 */


@RestController
public class TestConfigController {

    @Autowired
    private TestConfig testConfig;

    @GetMapping("/t/config")
    public TestConfig testConfig() {
        return testConfig;
    }


}
