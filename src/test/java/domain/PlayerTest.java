package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;
    private PlayerName playerName;
    private Position position;

    @BeforeEach
    public void setUp() {
        playerName = new PlayerName("Test");
        position = new Position(0);
        player = new Player(playerName, position);
    }

    @Test
    public void 플레이어는_정상적으로_생성된다() {
        assertThat(player.getPlayerName()).isEqualTo("Test");
        assertThat(player.getPosition()).isEqualTo(0);
    }
}
