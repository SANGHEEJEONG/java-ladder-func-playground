package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.TRUE;

public class LadderGenerator {

    private boolean randomTrueOrFalse() {
        return Math.random() < 0.5;         // 0.0(포함) - 1.0(미포함) 사이의 랜덤한 실수 반환
    }

    private boolean createValue(List<Boolean> line, int index) {
        if (index != 0 && line.get(index - 1) == TRUE)    // 이전 값이 True면 false 반환
            return false;

        return randomTrueOrFalse();
    }

    private Line createLine(int width) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < width - 1; i++) {
            points.add(createValue(points, i));
        }

        // 스트림 변환. 이 메서드에서는 for 문이 더 적합한 것 같아서 주석 처리.
        /*
            List<Boolean> points = IntStream.range(0, width - 1)
                                 .mapToObj(i -> createValue(points, i))
                                 .collect(Collectors.toList());
         */

        return new Line(points);
    }

    public Ladder createLadder(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createLine(width));
        }

        // 스트림 변환. 이 메서드에서는 for 문이 더 적합한 것 같아서 주석 처리.
        /*
            List<Line> lines = IntStream.range(0, height)
                                 .mapToObj(i -> createLine(width))
                                 .collect(Collectors.toList());
         */

        return new Ladder(lines);
    }
}
