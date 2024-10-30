package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;
    private Name name;
    private Position position;

    @BeforeEach
    public void setUp() {
        name = new Name("Test");
        position = new Position(0);
        player = new Player(name, position);
    }

    @Test
    public void 플레이어는_정상적으로_생성된다() {
        assertThat(player.getName()).isEqualTo("Test");
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    public void 플레이어는_왼쪽으로_이동할_수_있다() {
        position.movePositionRight(); // 오른쪽으로 이동
        player.moveLeft(); // 왼쪽으로 이동
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    public void 플레이어는_오른쪽으로_이동할_수_있다() {
        player.moveRight();
        assertThat(player.getPosition()).isEqualTo(1);
    }
}
