package com.pelensky.simplifiedttt;

import java.util.ArrayList;
import java.util.List;

class Game {

    final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player winner;

    Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    void takeTurn() {
        board.placeMarker(currentPlayer.chooseSpace(this), currentPlayer.getMarker());
        changeCurrentPlayer();
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    List<String> showBoard() {
        return board.getSpaces();
    }

    void changeCurrentPlayer() {
        currentPlayer =
                (currentPlayer.equals(player1)) ? (currentPlayer = player2) : (currentPlayer = player1);
    }

    boolean isGameOver() {
        return isGameWonBy(player1) || isGameWonBy(player2) || isGameTied();
    }

    private boolean isGameWonBy(Player player) {
        for (List<String> line : winningCombinations()) {
            if (line.stream().allMatch(space -> space.equals(player.getMarker()))) {
                winner = player;
                return true;
            }
        }
        return false;
    }

    boolean isGameTied() {
        return board.getAvailableSpaces().size() == 0 && !isGameWonBy(player1) && !isGameWonBy(player2);
    }

    private List<List<String>> winningCombinations() {
        List<List<String>> winningCombinations = new ArrayList<>();
        winningCombinations.addAll(board.getRows());
        winningCombinations.addAll(board.getColumns());
        winningCombinations.add(board.getLeftDiagonal());
        winningCombinations.add(board.getRightDiagonal());
        return winningCombinations;
    }

    Player getWinner() {
        return winner;
    }
}
