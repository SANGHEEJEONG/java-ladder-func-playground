package domain;

public class Player {

    private final PlayerName playerName;
    private final Position position;

    public Player(PlayerName name, Position position) {
        this.playerName = name;
        this.position = position;
    }

    public void moveLeft() {
        position.movePositionLeft();
    }

    public void moveRight() {
        position.movePositionRight();
    }

    public String getPlayerName() {
        return playerName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
