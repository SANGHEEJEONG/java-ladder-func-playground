package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public List<Player> createPlayer(List<String> playerNames) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), i));
        }

        return players;
    }

    public void movePlayer(Line line, Player player) {
        if (line.canMoveRight(player.getPosition())) {
            player.moveRight();
            return;
        }

        if (line.canMoveLeft(player.getPosition())) {
            player.moveLeft();
        }
    }

    private void moveEachPlayer(Ladder ladder, Player player) {
        ladder.getLadder().forEach(line -> movePlayer(line, player));
    }

    public void runGame(Ladder ladder, Players players) {
        players.getPlayers().forEach(player -> moveEachPlayer(ladder,player));
    }

}
