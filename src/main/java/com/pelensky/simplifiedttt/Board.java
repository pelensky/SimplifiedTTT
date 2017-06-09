package com.pelensky.simplifiedttt;

import java.util.ArrayList;
import java.util.List;

class Board {
  private final int size;
  private final int OFFSET = 1;
  List<String> spaces;

  Board(int size) {
    this.size = size;
    this.spaces = setUpBoard(size);
  }

  void placeMarker(int space, String marker) {
    if (isSpaceAvailable(space)) {
      spaces.set(space - OFFSET, marker);
    }
  }

  List<String> getSpaces() {
    return spaces;
  }

  private List<String> setUpBoard(int size) {
    List<String> spaces = new ArrayList<>();
    for (int i = OFFSET; i < size * size + OFFSET; i++) {
      spaces.add(String.valueOf(i));
    }
    return spaces;
  }

  List<Integer> getAvailableSpaces() {
    List<Integer> availableSpaces = new ArrayList<>();
    for (int i = OFFSET; i < getSpaces().size() + OFFSET; i++) {
      if (isSpaceAvailable(i)) {
        availableSpaces.add(i);
      }
    }
    return availableSpaces;
  }

  private boolean isSpaceAvailable(int space) {
    return getSpaces().get(space - OFFSET).equals(String.valueOf(space));
  }

  void resetSpace(int space) {
    spaces.set(space - 1, String.valueOf(space));
  }

  List<List<String>> splitRows() {
    List<List<String>> rows = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      rows.add(new ArrayList<>(getSpaces().subList(i * size, (size * i) + size)));
    }
    return rows;
  }

  List<List<String>> splitColumns() {
    List<List<String>> columns = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      List<String> column = new ArrayList<>(size);
      for (int j = 0; j < size; j++) {
        column.add(splitRows().get(j).get(i));
      }
      columns.add(column);
    }
    return columns;
  }

  List<String> splitLeftDiagonal() {
    List<String> leftDiagonal = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      leftDiagonal.add(splitRows().get(i).get(i));
    }
    return leftDiagonal;
  }

  List<String> splitRightDiagonal() {
    List<String> rightDiagonal = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      rightDiagonal.add(splitRows().get(i).get(size - (i + 1)));
    }
    return rightDiagonal;
  }
}
