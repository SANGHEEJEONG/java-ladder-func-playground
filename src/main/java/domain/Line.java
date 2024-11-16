package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int width) {
        this.points = new ArrayList<>();
        createLine(width);
    }

    public void createLine(int width) {
        for (int i = 0; i < width - 1; i++) {
            points.add(Point.createPoint(points, i));
        }
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

    public int getSize() {
        return points.size();
    }
}
