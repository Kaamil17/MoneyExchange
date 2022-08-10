package com.example.finalexchange.tester;

import com.example.finalexchange.controller.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//class ControllerTest {
//
//    @InjectMocks
//    private Controller controller;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(controller)
//                .build();
//    }
//
//    @Test
//    void getTransactionsData() {
//    }
//
//    @Test
//    void getTransactionsDataById() throws Exception {
//        mockMvc.perform(get("/transaction/{id}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("SHIT"));
//
//    }
//}