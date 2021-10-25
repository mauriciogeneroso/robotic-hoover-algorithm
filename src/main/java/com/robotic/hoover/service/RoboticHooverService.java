package com.robotic.hoover.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.robotic.hoover.model.Input;
import com.robotic.hoover.model.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Mauricio Generoso
 */
@Service
public class RoboticHooverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoboticHooverService.class.getName());

    private JdbcTemplate jdbcTemplate;
    private JsonMapper jsonMapper;

    @Autowired
    public RoboticHooverService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jsonMapper = new JsonMapper();
    }

    public Output cleanRoom(Input input) {
        var service = new RoomService(
                input.getRoomSize(), input.getCoords(), input.getPatches(), input.getInstructions());
        var output = service.execute();
        persist(input, output);
        return output;
    }

    private void persist(Input input, Output output) {
        try {
            String inputAsJson = jsonMapper.writeValueAsString(input);
            String outputAsJson = jsonMapper.writeValueAsString(output);
            jdbcTemplate.execute(
                    String.format("INSERT INTO robotichoover.history(input, output) VALUES (\'%s\', \'%s\');",
                            inputAsJson, outputAsJson));
        } catch (JsonProcessingException ex) {
            LOGGER.error("Database error: {}", ex.getMessage());
        }
    }
}
