package domain;

public class PlayerName {

    private final String name;
    private final static int MAX_LENGTH = 5;
    private final static String INVALID_NAME = "all";

    public PlayerName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateMaxLength(name);
        validateNotBlank(name);
        validateNotEqualAll(name);
    }

    private void validateNotBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    private void validateNotEqualAll(String name) {
        if (name.equals(INVALID_NAME)) {
            throw new IllegalArgumentException("이름은 " + INVALID_NAME + "일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
