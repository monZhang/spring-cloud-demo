package com.chainovel.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityDataController {

    @GetMapping("/citys")
    public List<String> citys() {
        final ArrayList<String> citys = new ArrayList<>();
        citys.add("北京");
        citys.add("海淀");
        citys.add("朝阳");
        citys.add("顺义");
        citys.add("怀柔");
        citys.add("通州");
        citys.add("昌平");
        citys.add("延庆");
        citys.add("丰台");
        citys.add("石景山");
        citys.add("大兴");
        citys.add("房山");
        citys.add("密云");
        citys.add("门头沟");
        return citys;
    }
}
