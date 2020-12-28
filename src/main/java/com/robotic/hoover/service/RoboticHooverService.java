package com.robotic.hoover.service;

import com.robotic.hoover.utilities.RoomBuilder;

import java.util.List;

public class RoboticHooverService {

    private char[][] room;
    private int[][] currentPosition;
    private String instructions;

    public RoboticHooverService(int[] roomSize, int[] initialPosition, List<Integer[][]> patches, String instructions) {
        this.room = RoomBuilder.buildRoom(roomSize, patches);
        this.currentPosition = new int[][] {{initialPosition[0], initialPosition[1]}};
        this.instructions = instructions;
    }


}
