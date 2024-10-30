package domain;

public class Player {

    private final Name name;
    private final Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveLeft() {
        position.movePositionLeft();
    }

    public void moveRight() {
        position.movePositionRight();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
