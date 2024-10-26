package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private int decideWhereToGo(Line line, int ladderOrder) {
        if (ladderOrder != 0)
            ladderOrder = line.checkGoToRight(ladderOrder);

        if (ladderOrder != line.getSize() - 1)
            ladderOrder = line.checkGoToLeft(ladderOrder);

        return ladderOrder;
    }

    private int moveEachLadder(Ladder ladder, int ladderOrder) {
        int result = ladderOrder;
        for (Line line : ladder.getLadder()) {
            result = decideWhereToGo(line, result);
        }
        return result;
    }

    public List<Integer> runGame(Ladder ladder, int width) {
        List<Integer> result = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            result.add(moveEachLadder(ladder, i));
        }
        return result;
    }
}
