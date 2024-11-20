package domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void moveLeft() {
        if (position == 0) {
            throw new IllegalStateException("가장 왼쪽 사다리이므로 왼쪽으로 이동이 불가합니다.");
        }
        position--;
    }

    public void moveRight(int maxPosition) {
        if (position == maxPosition) {
            throw new IllegalStateException("가장 오른쪽 사다리이므로 오른쪽으로 이동이 불가합니다.");
        }
        position++;
    }

    public int getPosition() {
        return position;
    }
}
