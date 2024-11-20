package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderStepTest {

    @Test
    public void CONNECTED는_이동_가능하다() {
        LadderStep step = LadderStep.CONNECTED;

        boolean canMove = step.canMove();

        assertThat(canMove).isTrue();
    }

    @Test
    public void NOT_CONNECTED는_이동_불가능하다() {
        LadderStep step = LadderStep.NOT_CONNECTED;

        boolean canMove = step.canMove();

        assertThat(canMove).isFalse();
    }

    @Test
    public void CONNECTED에서_nextStep은_NOT_CONNECTED으로_변경된다() {
        LadderStep step = LadderStep.CONNECTED;

        LadderStep nextStep = step.nextStep();

        assertThat(nextStep).isEqualTo(LadderStep.NOT_CONNECTED);
    }

    @Test
    public void NOT_CONNECTED에서_nextStep은_랜덤값에_따라_결정된다() {
        LadderStep step = LadderStep.NOT_CONNECTED;

        LadderStep nextStep = step.nextStep();

        assertThat(nextStep).isIn(LadderStep.CONNECTED, LadderStep.NOT_CONNECTED);
    }

    @Test
    public void randomTrueOrFalse는_true를_반환할_수_있다() {
        boolean hasReturnedTrue;

        do {
            hasReturnedTrue = LadderStep.randomTrueOrFalse();
        } while (!hasReturnedTrue);

        assertThat(hasReturnedTrue).isTrue();
    }

    @Test
    public void randomTrueOrFalse는_false를_반환할_수_있다() {
        boolean hasReturnedTrue;

        do {
            hasReturnedTrue = LadderStep.randomTrueOrFalse();
        } while (hasReturnedTrue);

        assertThat(hasReturnedTrue).isFalse();
    }
}
