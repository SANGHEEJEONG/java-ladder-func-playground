package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {

    private int moveEachLadder(Ladder ladder, int ladderOrder) {
        int result = ladderOrder;
        for (Line line : ladder.getLadder()) {
            result = line.checkWhereToGo(result);
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
