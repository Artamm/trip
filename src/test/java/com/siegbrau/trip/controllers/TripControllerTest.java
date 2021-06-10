package com.siegbrau.trip.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siegbrau.trip.model.TripInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TripControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {

    }

    @Test
    void startPageReturnsOk() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TripInfo tripInfo =
                new TripInfo(200D, null, null, "somewhere",
                        4, true);
        this.mockMvc.perform(post("/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tripInfo)))
                    .andExpect(status().isOk());
    }

}
