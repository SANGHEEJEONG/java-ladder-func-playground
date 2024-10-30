package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    private LadderGenerator ladderGenerator;

    @BeforeEach
    public void setUp() {
        ladderGenerator = new LadderGenerator();
    }

    @Test
    public void true와_false를_랜덤으로_반환한다() {
        boolean hasTrue = false;
        boolean hasFalse = false;

        for (int i = 0; i < 100; i++) {
            boolean result = ladderGenerator.randomTrueOrFalse();
            if (result) {
                hasTrue = true;
            } else {
                hasFalse = true;
            }

            // 두 값이 모두 나오면 테스트 종료
            if (hasTrue && hasFalse) {
                break;
            }
        }

        assertThat(hasTrue).isTrue();
        assertThat(hasFalse).isTrue();
    }

    @Test
    public void 이전_값이_true면_false를_반환한다() {
        List<Boolean> line = new ArrayList<>(List.of(true, false, false));
        boolean result = ladderGenerator.createValue(line, 1);

        assertThat(result).isFalse();
    }

    @Test
    public void 원하는_크기의_라인을_생성한다() {
        int width = 4;
        Line line = ladderGenerator.createLine(width);

        assertThat(line.getLine()).hasSize(width - 1);
        for (Boolean point : line.getLine()) {
            assertThat(point).isNotNull();
        }
    }

    @Test
    public void 원하는_크기의_사다리를_생성한다() {
        int width = 4;
        int height = 3;
        Ladder ladder = ladderGenerator.createLadder(width, height);

        assertThat(ladder.getLadder()).hasSize(height);
    }
}
