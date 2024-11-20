package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerNameTest {

    @Test
    public void 유효한_이름으로_생성된다() {
        PlayerName name = new PlayerName("Test");
        assertThat(name.toString()).isEqualTo("Test");
    }

    @Test
    public void 이름이_공백이면_예외를_던진다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PlayerName("                       "))
                .withMessage("이름은 공백일 수 없습니다.");
    }

    @Test
    public void 이름이_5자를_초과하면_예외를_던진다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PlayerName("TestTest"))
                .withMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    public void 이름이_all이면_예외를_던진다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PlayerName("all"))
                .withMessage("이름은 all일 수 없습니다.");
    }

    @Test
    public void 이름이_5자_이하의_경우_정상_생성된다() {
        PlayerName name = new PlayerName("Test");
        assertThat(name.toString()).isEqualTo("Test");
    }

    @Test
    public void 같은_이름은_같은_객체로_취급된다() {
        PlayerName name1 = new PlayerName("Test");
        PlayerName name2 = new PlayerName("Test");

        assertThat(name1).isEqualTo(name2);
    }

    @Test
    public void 다른_이름은_다른_객체로_취급된다() {
        PlayerName name1 = new PlayerName("Test1");
        PlayerName name2 = new PlayerName("Test2");

        assertThat(name1).isNotEqualTo(name2);
    }
}
