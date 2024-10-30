package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private LadderGame ladderGame;
    private Player player;
    private Ladder ladder;
    private Line lineRight;
    private Line lineLeft;
    private Line lineNone;

    @BeforeEach
    public void setUp() {
        ladderGame = new LadderGame();

        // test 사다리 생성
        lineRight = new Line(List.of(true, false, false));   // 첫 번째 사람 오른쪽 이동
        lineLeft = new Line(List.of(true, false, false));    // 두 번째 사람 왼쪽 이동
        lineNone = new Line(List.of(false, false, false));    // 세 번째 사람 그대로

        ladder = new Ladder(List.of(lineRight, lineLeft, lineNone));
    }

    @Test
    public void 플레이어는_오른쪽으로_이동할_수_있다() {
        player = new Player(new Name("Test"), new Position(0));

        ladderGame.movePlayer(lineRight, player);  // 첫 번째 줄에서 오른쪽으로 이동

        assertThat(player.getPosition()).isEqualTo(1);
    }

    @Test
    public void 플레이어는_왼쪽으로_이동할_수_있다() {
        player = new Player(new Name("Test"), new Position(1));

        ladderGame.movePlayer(lineLeft, player);  // 두 번째 줄에서 왼쪽으로 이동

        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    public void 플레이어는_이동하지_않을_수_있다() {
        player = new Player(new Name("Test"), new Position(2));

        ladderGame.movePlayer(lineNone, player);  // 이동 불가능한 줄에서 시도

        assertThat(player.getPosition()).isEqualTo(2);
    }

    @Test
    public void 플레이어는_각_라인을_타고_최종_위치에_도달한다() {
        player = new Player(new Name("Test"), new Position(0));

        ladderGame.moveEachPlayer(ladder, player);  // 각 라인에 대해 이동

        assertThat(player.getPosition()).isEqualTo(0); // 첫 번째 사람은 결국 첫 번째 결과에 도달
    }

    @Test
    public void testRunGame() {
        Players players = new Players(List.of("Test1", "Test2", "Test3"));
        Player player1 = players.getPlayers().get(0);
        Player player2 = players.getPlayers().get(1);
        Player player3 = players.getPlayers().get(2);

        ladderGame.runGame(ladder, players);

        assertThat(player1.getPosition()).isEqualTo(0);
        assertThat(player2.getPosition()).isEqualTo(1);
        assertThat(player3.getPosition()).isEqualTo(2);
    }
}
