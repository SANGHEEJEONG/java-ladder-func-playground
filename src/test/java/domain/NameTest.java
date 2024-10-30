package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {

    @Test
    public void 유효한_이름으로_생성된다() {
        Name name = new Name("Test");
        assertThat(name.getName()).isEqualTo("Test");
    }

    @Test
    public void 이름이_공백이면_예외를_던진다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(" "))
                .withMessage("이름은 공백일 수 없습니다.");
    }

    @Test
    public void 이름이_5자를_초과하면_예외를_던진다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name("TestTest"))
                .withMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    public void 이름이_all이면_예외를_던진다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name("all"))
                .withMessage("이름은 all일 수 없습니다.");
    }

    @Test
    public void 이름이_5자_이하의_경우_정상_생성된다() {
        Name name = new Name("Test");
        assertThat(name.getName()).isEqualTo("Test");
    }
}
