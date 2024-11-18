package domain;

import java.util.List;
import java.util.function.Function;

public enum LadderStep {
    CONNECTED {
        @Override
        public boolean canMove() {
            return true;
        }

        @Override
        public LadderStep nextStep(List<LadderStep> line, int lineIndex) {
            return NOT_CONNECTED;
        }
    },
    NOT_CONNECTED {
        @Override
        public boolean canMove() {
            return false;
        }

        @Override
        public LadderStep nextStep(List<LadderStep> line, int lineIndex) {
            return FROM_BOOLEAN.apply(randomTrueOrFalse());
        }
    };

    public abstract boolean canMove();
    public abstract LadderStep nextStep(List<LadderStep> line, int lineIndex);

    public static final Function<Boolean, LadderStep> FROM_BOOLEAN = value -> {
        if (value) {
            return CONNECTED;
        }
        return NOT_CONNECTED;
    };

    static boolean randomTrueOrFalse() {
        return Math.random() < 0.5;
    }
}
