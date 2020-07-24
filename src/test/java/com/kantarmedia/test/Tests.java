package com.kantarmedia.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Tests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sortTest() throws Exception {

        mockMvc.perform(get("/sort")
                .contentType("application/json")
                .queryParam("values", "10,5,18,35,4,78"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().json("{\"value\":[4,5,10,18,35,78]}"));
    }

    @Test
    public void reverseTest() throws Exception {

        mockMvc.perform(get("/reverse")
                .contentType("application/json")
                .queryParam("values", "10,5,18,35,4,78"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().json("{\"value\":[78,35,18,10,5,4]}"));
    }

    @Test
    public void isClientErrorTest() throws Exception {

        String[] testData = new String[]{"abcd", "'@#$#@$#@$#$", ""};

        for (String data : testData) {
            mockMvc.perform(get("/reverse")
                    .contentType("application/json")
                    .queryParam("values", data))
                    .andExpect(status().is4xxClientError())
                    .andDo(MockMvcResultHandlers.print());
        }
    }

    @Test
    public void isClientErrorWithInvalidEndpointTest() throws Exception {

        mockMvc.perform(get("/abcd")
                .contentType("application/json")
                .queryParam("values", "10,5,18,35,4,78"))
                .andExpect(status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());

    }
}
