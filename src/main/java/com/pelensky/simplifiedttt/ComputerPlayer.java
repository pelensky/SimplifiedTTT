package com.pelensky.simplifiedttt;

public class ComputerPlayer implements Player {

    private final String marker;

    ComputerPlayer(String marker) {
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return marker;
    }
}
