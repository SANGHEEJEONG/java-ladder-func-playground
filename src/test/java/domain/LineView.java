package domain;

public enum LineView {
    CONNECTION(true,"-----"),
    DISCONNECTION(false,"     ");

    private final boolean value;
    private final String view;

    LineView(boolean value, String view) {
        this.value = value;
        this.view = view;
    }
}
