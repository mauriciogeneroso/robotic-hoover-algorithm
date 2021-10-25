package com.robotic.hoover.service;

import com.robotic.hoover.model.Direction;
import com.robotic.hoover.model.Output;
import com.robotic.hoover.model.RoomSituation;
import com.robotic.hoover.utilities.RoomBuilder;

import java.util.List;
import java.util.Objects;

/**
 * @author Mauricio Generoso
 */
public class RoomService {

    private char[][] room;
    private int[][] currentPosition;
    private String instructions;
    private int cleanedSpaces;

    public RoomService(int[] roomSize, int[] initialPosition, List<Integer[]> patches, String instructions) {
        this.room = RoomBuilder.buildRoom(roomSize, patches);
        this.currentPosition = new int[][]{{initialPosition[0], initialPosition[1]}};
        this.instructions = Objects.isNull(instructions) ? "" : instructions;
    }

    public Output execute() {
        for (var i = 0; i < instructions.length(); i++) {
            Direction direction = Direction.of(instructions.charAt(i));

            switch (direction) {
                case NORTH:
                    moveToEast();
                    break;
                case EAST:
                    moveToSouth();
                    break;
                case SOUTH:
                    moveToWest();
                    break;
                case WEST:
                    moveToNorth();
                    break;
            }
            verifyIfIsDirty();
        }

        return new Output(
                new int[]{currentPosition[0][0], currentPosition[0][1]},
                cleanedSpaces
        );
    }

    private void moveToNorth() {
        if (currentPosition[0][0] > 0) {
            currentPosition[0][0]--;
        }
    }

    private void moveToSouth() {
        if (currentPosition[0][0] < room.length - 1) {
            currentPosition[0][0]++;
        }
    }

    private void moveToEast() {
        if (currentPosition[0][1] < room[0].length - 1)
            currentPosition[0][1]++;
    }

    private void moveToWest() {
        if (currentPosition[0][1] > 0) {
            currentPosition[0][1]--;
        }
    }

    private void verifyIfIsDirty() {
        if (isDirty(currentPosition[0][0], currentPosition[0][1])) {
            cleanSpace(currentPosition[0][0], currentPosition[0][1]);
        }
    }

    private boolean isDirty(int x, int y) {
        return room[x][y] == RoomSituation.DIRTY.getSituation();
    }

    private void cleanSpace(int x, int y) {
        cleanedSpaces++;
        room[x][y] = RoomSituation.CLEAN.getSituation();
    }
}
