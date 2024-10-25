import domain.LadderGenerator;
import view.OutputView;
import view.InputView;

public class Main {
    public static void main(String[] args) {
        final int width = InputView.inputWidth();
        final int height = InputView.inputHeight();
        final LadderGenerator ladderGenerator = new LadderGenerator();
        OutputView.drawLadder(ladderGenerator.createLadder(width,height));
    }
}
