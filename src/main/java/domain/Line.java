package domain;

import java.util.List;

import static java.lang.Boolean.TRUE;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean canMoveRight(int ladderOrder) {
        return (ladderOrder < points.size()) && (points.get(ladderOrder) == TRUE);
    }

    public boolean canMoveLeft(int ladderOrder) {
        return (ladderOrder != 0) && (points.get(ladderOrder - 1) == TRUE);
    }

    public List<Boolean> getLine() {
        return points;
    }
}
