package com.pelensky.simplifiedttt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ComputerPlayer implements Player {

  private final String marker;

  ComputerPlayer(String marker) {
    this.marker = marker;
  }

  @Override
  public String getMarker() {
    return marker;
  }



  @Override
  public int chooseSpace(Game game) {
    if (game.getTurnCount() < 5 && game.board.getSpaces().size() > 9) {
      return chooseRandomSpace(game);
    } else {
      Map<Integer, Integer> bestScore = new HashMap<>();
      return calculateBestMove(game, 0, bestScore);
    }
  }



  private int calculateBestMove(Game game, int depth, Map<Integer, Integer> potentialOutcomes) {
    int TIEDGAME = 0;
    int WONGAME = -1;
    if (game.isGameTied()) {
      return TIEDGAME;
    } else if (game.isGameOver()) {
      return WONGAME;
    } else {
      checkPossibilities(game, depth, potentialOutcomes);
      if (depth == 0) {
        return chooseBestMove(potentialOutcomes);
      } else {
        return getTopScoreInThisScenario(potentialOutcomes);
      }
    }
  }

  private void checkPossibilities(Game game, int depth, Map<Integer, Integer> potentialOutcomes) {
    for (int space : game.board.getAvailableSpaces()) {
      emulateTurn(game, space);
      addPossibilityToOutcomes(game, depth, potentialOutcomes, space);
      resetBoard(game, space);
    }
  }

  private void emulateTurn(Game game, int space) {
    game.board.placeMarker(space, game.getCurrentPlayer().getMarker());
    game.changeCurrentPlayer();
  }
  private void addPossibilityToOutcomes(Game game, int depth, Map<Integer, Integer> potentialOutcomes, int space) {
    potentialOutcomes.put(space, (-1 * calculateBestMove(game, depth + 1, new HashMap<>())));
  }
  private void resetBoard(Game game, int space) {
    game.board.resetSpace(space);
    game.changeCurrentPlayer();
  }

  private int chooseBestMove(Map<Integer, Integer> potentialOutcomes) {
    return potentialOutcomes.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
  }

  private int getTopScoreInThisScenario(Map<Integer, Integer> potentialOutcomes) {
    return potentialOutcomes.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
  }

 int chooseRandomSpace(Game game) {
    List<Integer> spaces = game.board.getAvailableSpaces();
    return spaces.get(new Random().nextInt(spaces.size()));
  }
}
