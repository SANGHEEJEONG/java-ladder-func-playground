package domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void decideWhereToGo(Line line) {
        if (line.canMoveRight(position)){
            moveRight();
            return;
        }

        if (line.canMoveLeft(position)) {
            moveLeft();
        }
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
