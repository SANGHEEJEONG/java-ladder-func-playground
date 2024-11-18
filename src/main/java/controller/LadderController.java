package controller;

import domain.Ladder;
import domain.Players;
import domain.ResultTypes;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    public Players initializePlayers() {
        List<String> playerNames = InputView.splitString(InputView.inputNames());

        return new Players(playerNames);
    }

    public ResultTypes initializeResults(int resultsSize) {
        List<String> kindOfResults = InputView.splitString(InputView.inputLadderResults());

        return new ResultTypes(kindOfResults, resultsSize);
    }

    public Ladder initializeLadder(int width) {
        int height = InputView.inputHeight();

        return new Ladder(width, height);
    }

    public void playGame(Players players, Ladder ladder) {
        players.moveAllPlayers(ladder);
    }

    public void displayAllOutput(Players players, ResultTypes resultTypes, Ladder ladder){
        displayLadder(players, resultTypes, ladder);
        displayResults(resultTypes, players);
    }

    private void displayLadder(Players players, ResultTypes resultTypes, Ladder ladder) {
        OutputView.printPlayers(players);
        OutputView.drawLadder(ladder);
        OutputView.printResultTypes(resultTypes.getResultTypes());
    }

    private void displayResults(ResultTypes resultTypes, Players players) {
        OutputView.printResult(players, resultTypes.getResultTypes());
    }
}
