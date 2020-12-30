package com.robotic.hoover.controller;

import com.robotic.hoover.model.Input;
import com.robotic.hoover.model.Output;
import com.robotic.hoover.service.RoboticHooverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mauricio Generoso
 */
@RestController
@RequestMapping(path = "/execute")
public class RoboticHooverController {

    @Autowired
    private RoboticHooverService service;

    @PostMapping
    public ResponseEntity<Output> execute(@RequestBody Input input) {
        return ResponseEntity.ok(service.cleanRoom(input));
    }
}
