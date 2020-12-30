package com.robotic.hoover.utilities;

import com.robotic.hoover.model.RoomSituation;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Mauricio Generoso
 */
public final class RoomBuilder {

    public static char[][] buildRoom(int[] roomSize, List<Integer[]> patches) {
        char[][] room = new char[roomSize[0]][roomSize[1]];

        for (char[] chars : room) {
            Arrays.fill(chars, RoomSituation.CLEAN.getSituation());
        }

        if (!Objects.isNull(patches)) {
            patches.forEach(patch -> room[patch[0]][patch[1]] = RoomSituation.DIRTY.getSituation());
        }
        return room;
    }
}
