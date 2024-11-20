package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Players {

    private final List<Player> players;
    private final static int MIN_PLAYER_SIZE = 2;

    public Players(List<String> playerNames) {
        validateSize(playerNames);
        validateDuplicateName(playerNames);
        this.players = createPlayer(playerNames);
    }

    private void validateSize(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException("플레이어 수는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicateName(List<String> playerNames) {
        Set<String> playerNamesSet = new HashSet<>(playerNames);

        if (playerNames.size() != playerNamesSet.size()) {
            throw new IllegalArgumentException("동명이인인 플레이어가 존재합니다.");
        }
    }

    private List<Player> createPlayer(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(new PlayerName(playerNames.get(i)), new Position(i)));
        }

        return players;
    }

    public Player findByName(String viewerName) {
        PlayerName playerName = new PlayerName(viewerName);
        
        return players.stream()
                .filter(player -> player.getPlayerName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("플레이어 이름 '" + viewerName + "' 이 존재하지 않습니다."));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayersSize() {
        return players.size();
    }
}
