package com.robotic.hoover.service;

import com.robotic.hoover.model.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mauricio Generoso
 */
public class RoomServiceTest {

    @Test
    public void defaultTest() {
        // Arrange
        int[] roomSize = new int[]{5, 5};
        int[] initialPosition = new int[]{1, 2};
        List<Integer[]> patches = new ArrayList<>();
        String instructions = "NNESEESWNWW";

        patches.add(new Integer[]{1, 0});
        patches.add(new Integer[]{2, 2});
        patches.add(new Integer[]{2, 3});

        RoomService service = new RoomService(roomSize, initialPosition, patches, instructions);

        Output expectedOutput = new Output(new int[]{1,3}, 1);

        // Act
        Output output = service.execute();

        // Assert
        Assertions.assertArrayEquals(expectedOutput.getCoords(), output.getCoords());
        Assertions.assertEquals(expectedOutput.getPatches(), output.getPatches());
    }
}
