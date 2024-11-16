package controller;

import domain.Ladder;
import domain.Players;
import domain.ResultTypes;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    public void run() {
        Players players = initializePlayers();
        ResultTypes resultTypes = initializeResults(players.getPlayersSize());
        Ladder ladder = initializeLadder(players.getPlayersSize());

        playGame(players, ladder);

        displayAllOutput(players, resultTypes, ladder);
    }

    private Players initializePlayers() {
        List<String> playerNames = InputView.splitString(InputView.inputNames());

        return new Players(playerNames);
    }

    private ResultTypes initializeResults(int resultsSize) {
        List<String> kindOfResults = InputView.splitString(InputView.inputLadderResults());

        return new ResultTypes(kindOfResults, resultsSize);
    }

    private Ladder initializeLadder(int width) {
        int height = InputView.inputHeight();

        return new Ladder(width, height);
    }

    private void playGame(Players players, Ladder ladder) {
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
