package com.pelensky.simplifiedttt;

class HumanPlayer implements Player {

  private final String marker;
  private final CLI cli;

  HumanPlayer(CLI cli, String marker) {
    this.marker = marker;
    this.cli = cli;
  }

  @Override
  public String getMarker() {
    return marker;
  }

  @Override
  public int chooseSpace(Game game) {
    return cli.getNumber();
  }
}
