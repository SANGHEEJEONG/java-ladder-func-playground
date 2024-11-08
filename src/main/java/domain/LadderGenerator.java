package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private boolean randomTrueOrFalse() {
        return Math.random() < 0.5;         // 0.0(포함) - 1.0(미포함) 사이의 랜덤한 실수 반환
    }

    private Point createValue(List<Point> line, int lineIndex) {
        if (lineIndex != 0 && line.get(lineIndex - 1).isEnabled()) {    // 이전 값이 true 면 false 반환
            return Point.DISABLED;
        }

        return Point.FROM_BOOLEAN.apply(randomTrueOrFalse());
    }

    public Line createLine(int width) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < width - 1; i++) {
            points.add(createValue(points, i));
        }

        return new Line(points);
    }

    public Ladder createLadder(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createLine(width));
        }

        return new Ladder(lines);
    }
}
