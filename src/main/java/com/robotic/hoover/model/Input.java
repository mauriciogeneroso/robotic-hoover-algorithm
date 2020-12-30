package com.robotic.hoover.model;

import java.util.List;

/**
 * @author Mauricio Generoso
 */
public class Input {

    private int[] roomSize;
    private int[] coords;
    private List<Integer[]> patches;
    private String instructions;

    public int[] getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int[] roomSize) {
        this.roomSize = roomSize;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public List<Integer[]> getPatches() {
        return patches;
    }

    public void setPatches(List<Integer[]> patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
