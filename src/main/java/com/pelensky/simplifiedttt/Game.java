package com.pelensky.simplifiedttt;

class Game {

    private final Board board;
    private final Player player1;
    private final Player player2;

    Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
}
