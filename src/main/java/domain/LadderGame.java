package domain;

public class LadderGame {

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
        players.getPlayers().forEach(player -> moveEachPlayer(ladder, player));
    }

}
