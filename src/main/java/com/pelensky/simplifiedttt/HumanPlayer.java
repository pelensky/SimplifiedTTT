package com.pelensky.simplifiedttt;

class HumanPlayer implements Player{

    private String marker;

    HumanPlayer(String marker) {
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return marker;
    }




}
