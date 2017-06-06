package com.pelensky.simplifiedttt;

import java.util.ArrayList;
import java.util.List;

class Board {


  List<String> spaces;
  private final int offset = 1;

  Board(int size) {
    this.spaces = setUpBoard(size);
  }

  void placeMarker(int space, String marker) {
    spaces.set(space - offset, marker);
  }


    List<String> getSpaces() {
    return spaces;
  }

  private List<String> setUpBoard(int size) {
    List<String> spaces = new ArrayList<>();
    for (int i = offset; i < size * size + offset; i++) {
      spaces.add(String.valueOf(i));
    }
    return spaces;
  }

  List<Integer> getAvailableSpaces() {
    List<Integer> availableSpaces = new ArrayList<>();
    for (int i = offset; i < getSpaces().size() + offset; i++) {
      if (isSpaceAvailable(i)) {
        availableSpaces.add(i);
      }
    }
    return availableSpaces;
  }

  private boolean isSpaceAvailable(int space) {
    return getSpaces().get(space - offset).equals(String.valueOf(space));
  }
}
