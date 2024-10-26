package domain;

import java.util.List;

import static java.lang.Boolean.TRUE;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int checkWhereToGo(int ladderOrder) {
        int right = ladderOrder + 1;
        if (ladderOrder < points.size() && points.get(ladderOrder) == TRUE)
            return right;

        int left = ladderOrder - 1;
        if (ladderOrder != 0 && points.get(left) == TRUE)
            return left;

        return ladderOrder;
    }

    public List<Boolean> getLine() {
        return points;
    }
}
