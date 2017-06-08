package com.pelensky.simplifiedttt;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
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
    startGame();
    while (!game.isGameOver()) {
      oneTurn();
    }
    printOutcome();
  }

  private void startGame() {
    clearScreen();
    welcome();
    setUpGame();
  }

  private void oneTurn() {
    clearScreen();
    printPlayersTurn();
    printBoard();
    game.takeTurn();
  }

  private void printOutcome() {
    if (game.getWinner() != null) {
      printWinner();
    } else {
      printTie();
    }
    printBoard();
  }

  private void setUpGame() {
    board = chooseBoardSize();
    Player player1 = choosePlayerType(1);
    Player player2 = choosePlayerType(2);
    game = new Game(board, player1, player2);
  }

  private Board chooseBoardSize() {
    printBoardSizeOptions();
    List<Integer> validOptions = Arrays.asList(3,4);
    return new Board(getNumber(validOptions));
  }

  private Player choosePlayerType(int player) {
    printPlayerSelectionOptions(player);
    String marker = getMarker(player);
    List<Integer> validOptions = Arrays.asList(1,2);
    return getNumber(validOptions) == 1 ? new HumanPlayer(this, marker) : new ComputerPlayer(marker);
  }

  private String getMarker(int player) {
    return player == 1 ? "X" : "O";
  }

  int getNumber(List<Integer> validOptions) {
    int selection = checkInteger();
    if (validOptions.contains(selection)) {
      return selection;
    } else {
      printInvalidSelection();
      return getNumber(validOptions);
    }
  }

  private int checkInteger() {
    try {
      return in.nextInt();
    } catch (InputMismatchException e) {
      printInvalidSelection();
      in.next();
      return checkInteger();
    }
  }

  private void welcome() {
    out.println("Tic Tac Toe");
  }

  private void printBoardSizeOptions() {
    out.println("Choose Board Size: 3 or 4");
  }

  private void printPlayerSelectionOptions(int player) {
    out.println("Choose Player Type for Player " + player + ":");
    out.println("1) Human");
    out.println("2) Computer");
  }

  private void printPlayersTurn() {
    out.println(game.getCurrentPlayer().getMarker() + " take your turn");
  }

  private void printWinner() {
    out.println(game.getWinner().getMarker() + " is the winner!");
  }

  private void printTie() {
    out.println("The game was tied");
  }

  private void printInvalidSelection() {
    out.println("Invalid Selection");
  }

  private void printBoard() {
    StringBuilder boardOutput = new StringBuilder();
    List<List<String>> rows = board.splitRows();
    for (int row = 0; row < rows.size() - 1; row++) {
      String rowText = formatRow(rows.get(row));
      boardOutput
          .append(rowText)
          .append(System.lineSeparator())
          .append(formatSeparator(rowText.length()));
    }
    boardOutput.append(formatRow(rows.get(rows.size() - 1))).append(System.lineSeparator());
    out.println(boardOutput);
  }

  private String formatRow(List<String> row) {
    String separator = " | ";
    String offset = " ";
    StringBuilder formattedRow = new StringBuilder(offset);
    for (int space = 0; space < row.size() - 1; space++) {
      formattedRow.append(padSpace(offset, row.get(space))).append(separator);
    }
    formattedRow.append(padSpace(offset, row.get(row.size() - 1)));
    return String.valueOf(formattedRow);
  }

  private String padSpace(String offset, String space) {
    return space.length() == 1 ? offset + space : space;
  }

  private String formatSeparator(int length) {
    StringBuilder line = new StringBuilder();
    for (int character = 0; character < length; character++) {
      line.append("-");
    }
    line.append("-").append(System.lineSeparator());
    return line.toString();
  }

  private void clearScreen() {
    String CLEAR_SCREEN = "\033[H\033[2J";
    out.print(CLEAR_SCREEN);
    out.flush();
  }
}
