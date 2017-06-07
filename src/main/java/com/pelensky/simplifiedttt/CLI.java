package com.pelensky.simplifiedttt;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

class CLI {

    private final Scanner in;
    private final PrintStream out;
    private Game game;
    private Board board;


    CLI(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        welcome();
        setUpGame();
        while (!game.isGameOver()) {
            printPlayersTurn();
            printBoard();
            takeTurn();
        }
        printOutcome();

    }

    private void printOutcome() {
        if (game.getWinner() != null) {
            printWinner();
        } else {
            printTie();
        }
    }

    private void printTie() {
        out.println("The game was tied");
    }

    private void printWinner() {
        out.println(game.getWinner().getMarker() + " is the winner!");
    }

    private void takeTurn() {
        game.takeTurn();
    }

    private void setUpGame() {
        board = chooseBoardSize();
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

    private void printPlayersTurn() {
        out.println(game.getCurrentPlayer().getMarker() + " take your turn");
    }

    private void printBoard() {
        StringBuilder boardOutput = new StringBuilder();
        List<List<String>> rows = board.getRows();
        for (int row = 0; row < rows.size() - 1; row ++) {
            String rowText = formatRow(rows.get(row));
            boardOutput.append(rowText).append(System.lineSeparator()).append(formatLine(rowText.length()));
        }
        boardOutput.append(formatRow(rows.get(rows.size() - 1))).append(System.lineSeparator());
        out.println(boardOutput);
    }

    private String formatRow(List<String> row) {
        String separator = " | ";
        String offset = " ";
        StringBuilder formattedRow = new StringBuilder(offset);
        for (int space = 0; space < row.size() - 1; space ++) {
            formattedRow.append(padSpace(offset, row.get(space))).append(separator);
        }
        formattedRow.append(padSpace(offset, row.get(row.size() - 1)));
        return String.valueOf(formattedRow);
    }

    private String padSpace(String offset, String space) {
        return space.length() == 1 ? offset + space : space;
    }

    private String formatLine(int length) {
        StringBuilder line = new StringBuilder();
        for (int character = 0; character < length; character++) {
            line.append("-");
        }
        line.append("-").append(System.lineSeparator());
        return line.toString();
    }

}
