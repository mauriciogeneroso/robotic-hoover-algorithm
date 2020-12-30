package com.robotic.hoover.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotic.hoover.model.Input;
import com.robotic.hoover.model.Output;
import com.robotic.hoover.service.RoboticHooverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoboticHooverController.class)
public class RoboticHooverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoboticHooverService service;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        // Arrange
        Input input = new Input();
        Output output = new Output(new int[]{1, 1}, 0);

        when(service.cleanRoom(any())).thenReturn(output);

        // Act
        ResultActions result = this.mockMvc.perform(post("/execute")
                .content(objectMapper.writeValueAsString(input))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // Assert
        verify(service, times(1)).cleanRoom(any());
        result.andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(output)));
    }
}
