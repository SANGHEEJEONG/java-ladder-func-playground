package domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void decideWhereToGo(Line line) {
        if (line.canMoveRight(position)) {
            moveRight(line.getSize());
            return;
        }

        if (line.canMoveLeft(position)) {
            moveLeft();
        }
    }

    public void moveLeft() {
        if (position != 0) {
            position--;
        }
    }

    public void moveRight(int maxPosition) {
        if (position != maxPosition) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
