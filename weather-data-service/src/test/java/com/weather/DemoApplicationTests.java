package com.weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void initEnv() {
        mockMvc = MockMvcBuilders.standaloneSetup(webApplicationContext).build();
    }


    @Test
    public void contextLoads() throws Exception {
        // 执行一个RequestBuilder请求   contentType(MediaType.APPLICATION_JSON).content(requestBody)
        ResultActions perform = mockMvc.perform(post("/weather/北京"));
        System.out.println(perform);


    }

}
