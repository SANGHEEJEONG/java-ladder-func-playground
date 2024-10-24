import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class LadderGenerator {
    private final static int HEIGHT = 4;
    private final static int WIDTH = HEIGHT - 1;


    private boolean randomTrueOrFalse() {
        return Math.random() < 0.5;         // 0.0(포함) - 1.0(미포함) 사이의 랜덤한 실수 반환
    }

    private boolean createValue(List<Boolean> line, int index) {
        if (index == 0)                     // index가 0이면 랜덤값 반환
            return randomTrueOrFalse();
        if (line.get(index - 1) == TRUE)    // 이전 값이 True면 false 반환
            return false;

        return randomTrueOrFalse();
    }

    private void createLine() {
        List<Boolean> points = new ArrayList<>(4);

        for (int i = 0; i < WIDTH; i++) {
            points.add(createValue(points, i));
        }
    }
}
