package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    public void setUp() {
        // line = new Line(List.of(Point.ENABLED, Point.DISABLED, Point.ENABLED));
    }

    @Test
    public void 특정_위치에서_오른쪽으로_이동할_수_있다() {
        // 0번째 위치에서 오른쪽으로 이동 가능 여부 확인
        assertThat(line.canMoveRight(0)).isTrue();
    }

    @Test
    public void 특정_위치에서_오른쪽으로_이동할_수_없다() {
        // 3번째 위치에서 오른쪽으로 이동 불가능 여부 확인
        assertThat(line.canMoveRight(3)).isFalse();
    }

    @Test
    public void 특정_위치에서_왼쪽으로_이동할_수_있다() {
        // 3번째 위치에서 왼쪽으로 이동 가능 여부 확인
        assertThat(line.canMoveLeft(3)).isTrue();
    }

    @Test
    public void 특정_위치에서_왼쪽으로_이동할_수_없다() {
        // 0번째 위치에서 왼쪽으로 이동 불가능 여부 확인
        assertThat(line.canMoveLeft(0)).isFalse();
    }
}
