package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {

    private Line line;

    @BeforeEach
    void 설정() throws Exception {
        line = new Line(3);

        Field ladderStepsField = Line.class.getDeclaredField("ladderSteps");
        ladderStepsField.setAccessible(true);

        List<LadderStep> fixedSteps = Arrays.asList(
                LadderStep.CONNECTED,
                LadderStep.NOT_CONNECTED,
                LadderStep.CONNECTED
        );
        ladderStepsField.set(line, fixedSteps);
    }

    @Test
    void 오른쪽으로_이동_테스트() {
        Position position = new Position(0);
        line.decideWhereToGo(position);
        assertEquals(1, position.getPosition());
    }

    @Test
    void 왼쪽으로_이동_테스트() {
        Position position = new Position(3);
        line.decideWhereToGo(position);
        assertEquals(2, position.getPosition());
    }
}
