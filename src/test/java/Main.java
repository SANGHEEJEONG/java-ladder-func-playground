import domain.GameResult;
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

        final Players players = new Players(playerNames);

        final int width = players.getPlayersSize();
        final int height = InputView.inputHeight();

        final LadderGenerator ladderGenerator = new LadderGenerator();
        final Ladder ladder = ladderGenerator.createLadder(width,height);
        final LadderGame ladderGame = new LadderGame();
        final List<Integer> resultList = ladderGame.runGame(ladder,width);

        final GameResult gameResult = new GameResult();
        gameResult.makeMap(playerNames,kindOfResults,resultList);

        OutputView.printPlayers(players.getPlayersNames());
        OutputView.drawLadder(ladder);
        OutputView.printKindOfResults(kindOfResults);

        final String viewerPlayer = InputView.inputViewerName();
        OutputView.printResult(gameResult.getResultMap(),viewerPlayer);
    }
}
