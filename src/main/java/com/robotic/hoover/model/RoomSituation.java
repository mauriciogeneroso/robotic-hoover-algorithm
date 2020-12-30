package com.robotic.hoover.model;

/**
 * @author Mauricio Generoso
 */
public enum RoomSituation {
    CLEAN('C'), DIRTY('D');

    private char situation;

    RoomSituation(char situation) {
        this.situation = situation;
    }

    public char getSituation() {
        return situation;
    }
}
