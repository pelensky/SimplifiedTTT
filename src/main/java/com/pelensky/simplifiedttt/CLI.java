package com.pelensky.simplifiedttt;

import java.io.PrintStream;
import java.util.Scanner;

class CLI {

    private Scanner in;
    private PrintStream out;
    boolean gameOver = false;

    CLI(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void gameLoop() {
        out.println("Tic Tac Toe");
        out.println("Choose Board Size: 3 or 4");
        Board board = new Board(getNumber());
        Player player1 = choosePlayerType(1);
        Player player2 = choosePlayerType(2);

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


}
