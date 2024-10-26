package domain;

import java.util.List;

public class LadderGame {

    private int decideWhereToGo(Line line, int ladderOrder) {
        if (ladderOrder != 0)
            ladderOrder = line.checkGoToRight(ladderOrder);

        if (ladderOrder != line.getSize() - 1)
            ladderOrder = line.checkGoToLeft(ladderOrder);

        return ladderOrder;
    }

}
