package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리_생성_테스트() {
        int playerSize = 5;
        int width = 4;
        int height = 3;

        Ladder ladder = new Ladder(playerSize, height);
        List<Line> lines = ladder.getLadder();

        assertThat(lines).hasSize(height);
        lines.forEach(line -> assertThat(line.getLine()).hasSize(width));
    }


    @Test
    public void 사다리_결과가_사다리_범위_안에_존재해야_한다() {
        int width = 5;
        int height = 3;

        Ladder ladder = new Ladder(width, height);
        Players players = new Players(List.of("A", "B"));

        ladder.determineLadderResults(players);

        players.getPlayers().forEach(player ->
                assertThat(player.getPosition()).isGreaterThanOrEqualTo(0).isLessThan(width)
        );
    }
}
