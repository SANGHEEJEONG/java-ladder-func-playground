package domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @Test
    public void 플레이어가_정상적으로_생성된다() {
        List<String> playerNames = List.of("Test1", "Test2");
        Players players = new Players(playerNames);

        assertThat(players.getPlayersSize()).isEqualTo(2);
        assertThat(players.getPlayers().get(0).getName()).isEqualTo("Test1");
        assertThat(players.getPlayers().get(1).getName()).isEqualTo("Test2");
    }

    @Test
    public void 플레이어수가_2명_미만일_때_예외를_던진다() {
        List<String> playerNames = List.of("Test");

        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 수는 2명 이상이어야 합니다.");
    }

    @Test
    public void 존재하지_않는_플레이어를_찾을_때_예외를_던진다() {
        List<String> playerNames = List.of("Test1", "Test2");
        Players players = new Players(playerNames);

        assertThatThrownBy(() -> players.findByName("테스트"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("플레이어 이름 '테스트' 이 존재하지 않습니다.");
    }

    @Test
    public void 존재하는_플레이어를_정상적으로_찾는다() {
        List<String> playerNames = List.of("Test", "Test");
        Players players = new Players(playerNames);

        Player foundPlayer = players.findByName("Test");
        assertThat(foundPlayer.getName()).isEqualTo("Test");
    }
}
