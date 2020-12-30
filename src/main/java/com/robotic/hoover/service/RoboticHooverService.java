package com.robotic.hoover.service;

import com.robotic.hoover.model.Input;
import com.robotic.hoover.model.Output;
import org.springframework.stereotype.Service;

/**
 * @author Mauricio Generoso
 */
@Service
public class RoboticHooverService {

    public Output cleanRoom(Input input) {
        RoomService service = new RoomService(
                input.getRoomSize(), input.getCoords(), input.getPatches(), input.getInstructions());
        Output output = service.execute();
        return output;
    }
}
