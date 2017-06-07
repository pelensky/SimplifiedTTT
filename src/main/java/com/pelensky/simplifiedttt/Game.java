package com.pelensky.simplifiedttt;

import java.util.List;

class Game {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    void takeTurn(int space) {
        board.placeMarker(space, currentPlayer.getMarker());
        changeCurrentPlayer();
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    List<String> showBoard() {
        return board.getSpaces();
    }

    private void changeCurrentPlayer() {
        currentPlayer =
                (currentPlayer.equals(player1)) ? (currentPlayer = player2) : (currentPlayer = player1);
    }
}
