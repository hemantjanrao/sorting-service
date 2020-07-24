package com.kantarmedia.test.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

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
        mockMvc.perform(get("/reverse")
                .contentType("application/json")
                .queryParam("values", "abcd"))
                .andExpect(status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void isServeErrorTest() throws Exception {
        mockMvc.perform(post("/reverse")
                .contentType("application/json")
                .queryParam("values", "10,5,18,35,4,78"))
                .andExpect(status().is5xxServerError())
                .andDo(MockMvcResultHandlers.print());
    }



}
