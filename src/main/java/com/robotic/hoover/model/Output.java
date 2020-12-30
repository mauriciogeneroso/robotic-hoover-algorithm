package com.robotic.hoover.model;

/**
 * @author Mauricio Generoso
 */
public class Output {

    private int[] coords;
    private int patches;

    public Output(int[] coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public int getPatches() {
        return patches;
    }

    public void setPatches(int patches) {
        this.patches = patches;
    }
}
