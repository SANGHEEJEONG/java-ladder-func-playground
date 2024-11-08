package domain;

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

    public static final Function<Boolean, Point> FROM_BOOLEAN = value -> {
        if (value) {
            return ENABLED;
        }
        return DISABLED;
    };
}
