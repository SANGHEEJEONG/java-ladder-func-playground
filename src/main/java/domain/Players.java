package domain;

import java.util.List;
import java.util.NoSuchElementException;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
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
