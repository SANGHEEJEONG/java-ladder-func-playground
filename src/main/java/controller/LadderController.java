package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Players;
import domain.ResultTypes;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    private Players players;
    private Ladder ladder;

    public void run() {
        List<String> playerNames = InputView.splitString(InputView.inputNames());
        List<String> kindOfResults = InputView.splitString(InputView.inputLadderResults());

        // 플레이어 생성
        players = new Players(playerNames);
        // 결과 종류 생성
        ResultTypes resultTypes = new ResultTypes(kindOfResults, players.getPlayersSize());
        // 사다리 초기화
        initializeLadder();

        // 사다리 및 결과 출력
        displayLadder(resultTypes,playerNames);
        playGameAndDisplayResults(resultTypes);
    }

    private void initializeLadder() {
        int width = players.getPlayersSize();
        int height = InputView.inputHeight();
        LadderGenerator ladderGenerator = new LadderGenerator();
        ladder = ladderGenerator.createLadder(width, height);
    }

    private void displayLadder(ResultTypes resultTypes,List<String> playerNames) {
        OutputView.printPlayers(playerNames);
        OutputView.drawLadder(ladder);
        OutputView.printResultTypes(resultTypes.getResultTypes());
    }

    private void playGameAndDisplayResults(ResultTypes resultTypes) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.runGame(ladder, players);
        OutputView.printResult(players, resultTypes.getResultTypes());
    }
}
