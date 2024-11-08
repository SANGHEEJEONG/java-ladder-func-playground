package domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public boolean canMoveRight(int ladderOrder) {
        return (ladderOrder < points.size()) && (points.get(ladderOrder).isEnabled());
    }

    public boolean canMoveLeft(int ladderOrder) {
        return (ladderOrder != 0) && (points.get(ladderOrder - 1).isEnabled());
    }

    public List<Point> getLine() {
        return Collections.unmodifiableList(points);
    }
}
