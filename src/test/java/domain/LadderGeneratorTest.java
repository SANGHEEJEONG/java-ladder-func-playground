package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {

    private LadderGenerator ladderGenerator;

    @BeforeEach
    public void setUp() {
        ladderGenerator = new LadderGenerator();
    }

    @Test
    public void 원하는_크기의_라인을_생성한다() {
        int width = 4;
        Line line = ladderGenerator.createLine(width);

        assertThat(line.getLine()).hasSize(width - 1);
        for (Point point : line.getLine()) {
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
