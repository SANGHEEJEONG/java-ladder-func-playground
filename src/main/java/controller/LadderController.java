package controller;

import domain.Ladder;
import domain.LadderGenerator;
import domain.Players;
import domain.ResultTypes;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    public void run() {
        List<String> playerNames = InputView.splitString(InputView.inputNames());
        List<String> kindOfResults = InputView.splitString(InputView.inputLadderResults());

        // 플레이어 생성
        Players players = new Players(playerNames);
        // 결과 종류 생성
        ResultTypes resultTypes = new ResultTypes(kindOfResults, players.getPlayersSize());
        // 사다리 초기화
        Ladder ladder = initializeLadder(players);

        // 사다리 및 결과 출력
        displayLadder(resultTypes, playerNames, ladder);
        playGameAndDisplayResults(resultTypes, players, ladder);
    }

    private Ladder initializeLadder(Players players) {
        int width = players.getPlayersSize();
        int height = InputView.inputHeight();

        LadderGenerator ladderGenerator = new LadderGenerator();
        Ladder ladder = ladderGenerator.createLadder(width, height);

        return ladder;
    }

    private void displayLadder(ResultTypes resultTypes, List<String> playerNames, Ladder ladder) {
        OutputView.printPlayers(playerNames);
        OutputView.drawLadder(ladder);
        OutputView.printResultTypes(resultTypes.getResultTypes());
    }

    private void playGameAndDisplayResults(ResultTypes resultTypes, Players players, Ladder ladder) {
        players.moveAllPlayers(ladder);
        OutputView.printResult(players, resultTypes.getResultTypes());
    }
}
