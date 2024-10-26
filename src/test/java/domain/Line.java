package domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int checkWhereToGo(int ladderOrder) {
        int right = ladderOrder + 1;
        if (ladderOrder < points.size() && points.get(ladderOrder))
            return right;

        int left = ladderOrder - 1;
        if (ladderOrder != 0 && points.get(left))
            return left;

        return ladderOrder;
    }

    public List<Boolean> getLine() {
        return points;
    }
}
