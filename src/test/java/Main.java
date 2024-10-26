import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import view.OutputView;
import view.InputView;

public class Main {
    public static void main(String[] args) {
        final int width = InputView.inputWidth();
        final int height = InputView.inputHeight();

        final LadderGenerator ladderGenerator = new LadderGenerator();
        final Ladder ladder = ladderGenerator.createLadder(width,height);
        OutputView.drawLadder(ladder);

        final LadderGame ladderGame = new LadderGame();
        OutputView.printAllResult(ladderGame.runGame(ladder,width));
    }
}
