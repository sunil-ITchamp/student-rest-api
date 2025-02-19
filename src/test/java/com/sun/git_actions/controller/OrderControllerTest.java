package com.sun.git_actions.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldGetStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAddStudent() throws Exception {
        Student newStudent = new Student(3L, "Thomas");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(newStudent))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("{\"id\":3,\"name\":\"Thomas\"}"))
                //.andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.ALL))
                .andExpect( jsonPath("$.id", is(3)))
                .andExpect( jsonPath("$.name", is("Thomas")));
//                .andExpect(content().json("{\n" +
//                        "    \"id\": 3,\n" +
//                        "    \"name\": \"Thomas\"\n" +
//                        "}") );

    }
}