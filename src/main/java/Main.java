import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Players;
import view.OutputView;
import view.InputView;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        final List<String> playerNames = InputView.splitString(InputView.inputNames());
        final List<String> kindOfResults = InputView.splitString(InputView.inputLadderResults());

        // 플레이어 생성
        final LadderGame ladderGame = new LadderGame();
        final Players players = new Players(ladderGame.createPlayer(playerNames));

        final int width = players.getPlayersSize();
        final int height = InputView.inputHeight();

        // 사다리 생성
        final LadderGenerator ladderGenerator = new LadderGenerator();
        final Ladder ladder = ladderGenerator.createLadder(width,height);

        // 사다리 그리기
        OutputView.printPlayers(playerNames);
        OutputView.drawLadder(ladder);
        OutputView.printKindOfResults(kindOfResults);

        // 사다리 게임 시작
        ladderGame.runGame(ladder,players);

        // 결과 출력
        OutputView.printResult(players,kindOfResults);
    }
}
