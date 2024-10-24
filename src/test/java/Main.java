import domain.LadderGenerator;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGenerator ladderGenerator = new LadderGenerator();
        OutputView.drawLadder(ladderGenerator.createLadder());
    }
}
