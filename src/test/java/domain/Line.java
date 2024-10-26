package domain;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public int checkGoToRight(int ladderOrder) {
        int right = ladderOrder + 1;
        if (points.get(right))
            return right;

        return ladderOrder;
    }

    public int checkGoToLeft(int ladderOrder) {
        int left = ladderOrder - 1;
        if (points.get(left))
            return left;

        return ladderOrder;
    }

    public List<Boolean> getLine(){
        return points;
    }

    public int getSize(){
        return points.size();
    }
}
