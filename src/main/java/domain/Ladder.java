package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int width, int height) {
        this.lines = new ArrayList<>();
        createLadder(width, height);
    }

    public void createLadder(int width, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
    }

    public void determineLadderResults(Players players) {
        players.getPlayers().forEach(player -> player.moveAlongLadder(lines));
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
