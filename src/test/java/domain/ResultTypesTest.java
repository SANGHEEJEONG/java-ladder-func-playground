package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTypesTest {

    @Test
    public void 유효한_결과타입으로_생성된다() {
        List<String> resultTypes = List.of("Result1", "Result2", "Result3");
        ResultTypes resultTypesObject = new ResultTypes(resultTypes, 3);

        assertThat(resultTypesObject.getResultTypes()).containsExactly("Result1", "Result2", "Result3");
    }

    @Test
    public void 결과타입이_공백이면_예외를_던진다() {
        List<String> resultTypes = List.of("Result1", " ", "Result3");

        assertThatThrownBy(() -> new ResultTypes(resultTypes, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 공백일 수 없습니다.");
    }

    @Test
    public void 결과타입의_개수가_사다리의_개수와_다르면_예외를_던진다() {
        List<String> resultTypes = List.of("Result1", "Result2");

        assertThatThrownBy(() -> new ResultTypes(resultTypes, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 사다리의 개수와 일치해야 합니다.");
    }

    @Test
    public void 결과타입의_개수가_사다리의_개수와_일치해야_정상생성된다() {
        List<String> resultTypes = List.of("Result1", "Result2", "Result3");
        ResultTypes resultTypesObject = new ResultTypes(resultTypes, 3);

        assertThat(resultTypesObject.getResultTypes()).hasSize(3);
    }
}
