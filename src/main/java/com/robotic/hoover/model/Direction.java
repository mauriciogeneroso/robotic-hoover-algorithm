package com.robotic.hoover.model;

public enum Direction {
    NORTH('N'), SOUTH('S'), WEST('W'), EAST('E');

    private char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }
}
