import controller.LadderController;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Players;
import domain.ResultTypes;
import view.OutputView;
import view.InputView;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.run();
    }
}
