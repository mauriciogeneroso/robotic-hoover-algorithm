package com.robotic.hoover.model;

import java.util.Arrays;

/**
 * @author Mauricio Generoso
 */
public enum Direction {
    NORTH('N'), SOUTH('S'), WEST('W'), EAST('E');

    private char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public static Direction of(char direction) {
        return Arrays.stream(Direction.values())
                .filter(value -> value.getDirection() == direction)
                .findFirst().orElseThrow();
    }
}
