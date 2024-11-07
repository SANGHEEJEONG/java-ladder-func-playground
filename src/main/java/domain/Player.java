package domain;

import java.util.List;

public class Player {

    private final PlayerName playerName;
    private final Position position;

    public Player(PlayerName name, Position position) {
        this.playerName = name;
        this.position = position;
    }

    public void moveAlongLadder(List<Line> ladder) {
        ladder.forEach(this.position::moveAlongLine);
    }

    public String getPlayerName() {
        return playerName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
