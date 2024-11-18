package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.LadderStep.randomTrueOrFalse;

public class Line {
    private final List<LadderStep> ladderSteps;

    public Line(int width) {
        this.ladderSteps = new ArrayList<>();
        createLine(width);
    }

    public void createLine(int width) {
        ladderSteps.add(LadderStep.FROM_BOOLEAN.apply(randomTrueOrFalse()));

        for (int i = 1; i < width - 1; i++) {
            ladderSteps.add(ladderSteps.get(i - 1).nextStep(ladderSteps, i));
        }
    }

    public void decideWhereToGo(Position position) {
        int ladderOrder = position.getPosition();

        if ((ladderOrder < ladderSteps.size()) && (ladderSteps.get(ladderOrder).canMove())) {
            position.moveRight(ladderSteps.size());
            return;
        }

        if ((ladderOrder != 0) && (ladderSteps.get(ladderOrder - 1).canMove())) {
            position.moveLeft();
        }
    }

    public List<LadderStep> getLine() {
        return Collections.unmodifiableList(ladderSteps);
    }
}
