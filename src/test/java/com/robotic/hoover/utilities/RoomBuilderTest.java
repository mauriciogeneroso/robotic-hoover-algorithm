package com.robotic.hoover.utilities;

import com.robotic.hoover.model.RoomSituation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoomBuilderTest {

    @Test
    public void testDefaultSpacesAsCleaned() {
        // Arrange
        int[] roomSize = new int[]{5, 5};

        // Act
        char[][] room = RoomBuilder.buildRoom(roomSize, new ArrayList<>());

        // Assert
        for (char[] roomLine : room) {
            for (int i = 0; i < roomLine.length; i++) {
                Assertions.assertEquals(roomLine[i], RoomSituation.CLEAN.getSituation());
            }
        }
    }

    @Test
    public void testDirtyPositions() {
        // Arrange
        int[] roomSize = new int[]{5, 5};
        List<Integer[][]> patches = new ArrayList<>();
        patches.add(new Integer[][]{{1, 2}});
        patches.add(new Integer[][]{{3, 4}});

        // Act
        char[][] room = RoomBuilder.buildRoom(roomSize, patches);

        // Assert
        patches.forEach(patch ->
                Assertions.assertEquals(room[patch[0][0]][patch[0][1]], RoomSituation.DIRTY.getSituation()));
    }
}
