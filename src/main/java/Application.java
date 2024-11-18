import controller.LadderController;
import domain.Ladder;
import domain.Players;
import domain.ResultTypes;

public class Application {
    public static void main(String[] args) {
        runLadderGame();
    }

    private static void runLadderGame() {
        LadderController ladderController = new LadderController();

        Players players = ladderController.initializePlayers();
        ResultTypes resultTypes = ladderController.initializeResults(players.getPlayersSize());
        Ladder ladder = ladderController.initializeLadder(players.getPlayersSize());

        ladderController.playGame(players, ladder);

        ladderController.displayAllOutput(players, resultTypes, ladder);
    }
}
