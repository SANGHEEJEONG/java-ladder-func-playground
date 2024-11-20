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
            ladderSteps.add(ladderSteps.get(i - 1).nextStep());
        }
    }

    public void decideWhereToGo(Position position) {
        int ladderOrder = position.getPosition();

        if (canMoveRight(ladderOrder)) {
            position.moveRight(ladderSteps.size());
            return;
        }

        if (canMoveLeft(ladderOrder)) {
            position.moveLeft();
        }
    }

    private boolean canMoveRight(int ladderOrder) {
        return ladderOrder < ladderSteps.size() && ladderSteps.get(ladderOrder).canMove();
    }

    private boolean canMoveLeft(int ladderOrder) {
        return ladderOrder != 0 && ladderSteps.get(ladderOrder - 1).canMove();
    }

    public List<LadderStep> getLine() {
        return Collections.unmodifiableList(ladderSteps);
    }
}
