package com.pelensky.simplifiedttt;

import java.io.PrintStream;
import java.util.Scanner;

class CLI {

    private final Scanner in;
    private final PrintStream out;
    private Game game;


    CLI(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void gameLoop() {
        welcome();
        setUpGame();
        printBoard();
    }

      private void setUpGame() {
        Board board = chooseBoardSize();
        Player player1 = choosePlayerType(1);
        Player player2 = choosePlayerType(2);
        game = new Game(board, player1, player2);
    }

    private Board chooseBoardSize() {
        printBoardSizeOptions();
        return new Board(getNumber());
    }

    private void printBoardSizeOptions() {
        out.println("Choose Board Size: 3 or 4");
    }

    private void welcome() {
        out.println("Tic Tac Toe");
    }

    private Player choosePlayerType(int player) {
        printPlayerSelectionOptions(player);
        String marker = getMarker(player);
        return getNumber() == 1 ? new HumanPlayer(this, marker) : new ComputerPlayer(marker);
    }

    private void printPlayerSelectionOptions(int player) {
        out.println("Choose Player Type for Player " + player + ":");
        out.println("1) Human");
        out.println("2) Computer");
    }

    private String getMarker(int player) {
        return player == 1 ? "X" : "O";
    }

    int getNumber() {
        return in.nextInt();
    }

    private void printBoard() {
        out.println("  1 |  2 |  3" + System.lineSeparator() +
                "--------------" + System.lineSeparator() +
                "  4 |  5 |  6" + System.lineSeparator() +
                "--------------" + System.lineSeparator() +
                "  7 |  8 |  9" );
    }

}
