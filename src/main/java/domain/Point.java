package domain;

import java.util.List;
import java.util.function.Function;

public enum Point {
    ENABLED(true),
    DISABLED(false);

    private final boolean enabled;

    // 생성자를 통해 상태를 설정
    Point(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    private static boolean randomTrueOrFalse() {
        return Math.random() < 0.5;         // 0.0(포함) - 1.0(미포함) 사이의 랜덤한 실수 반환
    }

    public static Point createPoint(List<Point> line, int lineIndex) {
        if (lineIndex != 0 && line.get(lineIndex - 1).isEnabled()) {    // 이전 값이 true 면 false 반환
            return Point.DISABLED;
        }

        return Point.FROM_BOOLEAN.apply(randomTrueOrFalse());
    }

    public static final Function<Boolean, Point> FROM_BOOLEAN = value -> {
        if (value) {
            return ENABLED;
        }
        return DISABLED;
    };
}
