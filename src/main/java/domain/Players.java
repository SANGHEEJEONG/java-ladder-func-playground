package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Players {

    private final List<Player> players;
    private final static int MIN_PLAYER_SIZE = 2;

    public Players(List<String> playerNames) {
        validateSize(playerNames);
        this.players = createPlayer(playerNames);
    }

    private void validateSize(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException("플레이어 수는 2명 이상이어야 합니다.");
        }
    }

    public List<Player> createPlayer(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(new Name(playerNames.get(i)), new Position(i)));
        }

        return players;
    }

    public Player findByName(String viewerName) {
        return players.stream()
                .filter(player -> player.getName().equals(viewerName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("플레이어 이름 '" + viewerName + "' 이 존재하지 않습니다."));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersSize() {
        return players.size();
    }
}
