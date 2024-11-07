package domain;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class LadderGenerator {

    private boolean randomTrueOrFalse() {
        return Math.random() < 0.5;         // 0.0(포함) - 1.0(미포함) 사이의 랜덤한 실수 반환
    }

    private boolean createValue(List<Boolean> line, int lineIndex) {
        if (lineIndex != 0 && line.get(lineIndex - 1) == TRUE) {    // 이전 값이 true 면 false 반환
            return false;
        }

        return randomTrueOrFalse();
    }

    public Line createLine(int width) {
        List<Boolean> points = new ArrayList<>();
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
