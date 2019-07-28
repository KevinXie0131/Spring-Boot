package com.leonardo.assignment.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockCityControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void TestListAllCities() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/cities").contentType(MediaType.APPLICATION_JSON_UTF8))
                                    .andExpect(MockMvcResultMatchers.status().isOk())
                                    .andDo(MockMvcResultHandlers.print())
                                    .andReturn();
    }
}
