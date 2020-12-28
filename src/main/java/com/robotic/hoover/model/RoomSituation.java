package com.robotic.hoover.model;

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
