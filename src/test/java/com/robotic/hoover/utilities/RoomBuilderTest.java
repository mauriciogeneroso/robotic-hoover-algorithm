package com.robotic.hoover.utilities;

import com.robotic.hoover.model.RoomSituation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mauricio Generoso
 */
public class RoomBuilderTest {

    @Test
    public void testDefaultSpacesAsCleaned() {
        // Arrange
        var roomSize = new int[]{5, 5};

        // Act
        var room = RoomBuilder.buildRoom(roomSize, new ArrayList<>());

        // Assert
        for (var roomLine : room) {
            for (char c : roomLine) {
                Assertions.assertEquals(c, RoomSituation.CLEAN.getSituation());
            }
        }
    }

    @Test
    public void testDirtyPositions() {
        // Arrange
        var roomSize = new int[]{5, 5};
        List<Integer[]> patches = new ArrayList<>();
        patches.add(new Integer[]{1, 2});
        patches.add(new Integer[]{3, 4});

        // Act
        var room = RoomBuilder.buildRoom(roomSize, patches);

        // Assert
        patches.forEach(patch ->
                Assertions.assertEquals(room[patch[0]][patch[1]], RoomSituation.DIRTY.getSituation()));
    }
}
