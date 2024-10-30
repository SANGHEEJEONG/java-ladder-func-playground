import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Players;
import domain.ResultTypes;
import view.OutputView;
import view.InputView;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // 사다리 게임 시작
        final LadderGame ladderGame = new LadderGame();

        // 플레이어 생성
        final List<String> playerNames = InputView.splitString(InputView.inputNames());
        final Players players = new Players(playerNames);

        // 실행결과 생성
        final List<String> kindOfResults = InputView.splitString(InputView.inputLadderResults());
        final ResultTypes resultTypes = new ResultTypes(kindOfResults,players.getPlayersSize());

        // 사다리 생성
        final int width = players.getPlayersSize();
        final int height = InputView.inputHeight();

        final LadderGenerator ladderGenerator = new LadderGenerator();
        final Ladder ladder = ladderGenerator.createLadder(width,height);

        // 사다리 그리기
        OutputView.printPlayers(playerNames);
        OutputView.drawLadder(ladder);
        OutputView.printResultTypes(resultTypes.getResultTypes());

        // 사다리 게임 시작
        ladderGame.runGame(ladder,players);

        // 결과 출력
        OutputView.printResult(players,resultTypes.getResultTypes());
    }
}
