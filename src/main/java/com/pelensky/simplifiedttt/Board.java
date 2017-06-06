package com.pelensky.simplifiedttt;

import java.util.ArrayList;
import java.util.List;

class Board {


  private List<String> spaces;
  private final int offset = 1;

  Board(int size) {
    this.spaces = setUpBoard(size);
  }

  List<String> getSpaces() {
    return spaces;
  }

  private List<String> setUpBoard(int size) {
    ArrayList<String> spaces = new ArrayList<>();
    for (int i = offset; i < size * size + offset; i++) {
      spaces.add(String.valueOf(i));
    }
    return spaces;
  }
}
