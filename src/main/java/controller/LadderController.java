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
    public void run() {
        // 게임 로직 시작
        LadderGame ladderGame = new LadderGame();

        // 플레이어 생성
        List<String> playerNames = InputView.splitString(InputView.inputNames());
        Players players = new Players(playerNames);

        // 결과 생성
        List<String> kindOfResults = InputView.splitString(InputView.inputLadderResults());
        ResultTypes resultTypes = new ResultTypes(kindOfResults, players.getPlayersSize());

        // 사다리 생성
        int width = players.getPlayersSize();
        int height = InputView.inputHeight();

        LadderGenerator ladderGenerator = new LadderGenerator();
        Ladder ladder = ladderGenerator.createLadder(width, height);

        // 사다리 출력
        OutputView.printPlayers(playerNames);
        OutputView.drawLadder(ladder);
        OutputView.printResultTypes(resultTypes.getResultTypes());

        // 게임 시작 및 결과 출력
        ladderGame.runGame(ladder, players);
        OutputView.printResult(players, resultTypes.getResultTypes());
    }

}
