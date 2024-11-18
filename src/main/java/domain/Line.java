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

    public void decideWhereToGo(Position position) {
        int ladderOrder = position.getPosition();

        if ((ladderOrder < points.size()) && (points.get(ladderOrder).isEnabled())) {
            position.moveRight(points.size());
            return;
        }

        if ((ladderOrder != 0) && (points.get(ladderOrder - 1).isEnabled())) {
            position.moveLeft();
        }
    }

    public List<Point> getLine() {
        return Collections.unmodifiableList(points);
    }
}
