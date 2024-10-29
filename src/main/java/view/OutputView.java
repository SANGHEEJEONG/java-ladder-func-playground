package view;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;

import java.util.List;

import static java.lang.Boolean.TRUE;

public class OutputView {
    private static String changeValueToView(Boolean point) {
        if (point == TRUE)
            return "-----";

        return "     ";
    }

    private static void drawLine(Line line) {
        for (Boolean point : line.getLine()) {
            System.out.print("|");
            System.out.print(changeValueToView(point));
        }
        System.out.println("|");
    }

    public static void printPlayers(List<String> names) {
        System.out.println("\n사다리 결과\n");
        System.out.println();
        for (String name : names) {
            System.out.print(name);
        }
        System.out.println();
    }

    public static void printKindOfResults(List<String> kindOfResults) {
        for (String kind : kindOfResults) {
            System.out.print(kind);
        }
        System.out.println();
    }

    public static void drawLadder(Ladder Ladder) {
        for (Line lines : Ladder.getLadder()) {
            drawLine(lines);
        }
    }

    private static void printAllResult(Players players, List<String> kindOfResults) {
        for (Player player : players.getPlayers()) {
            System.out.println(player.getName() + " :" + kindOfResults.get(player.getPosition()));
        }
    }

    private static int findViewerPosition(Players players, String viewerName){
        return players.getPlayers().stream()
                .filter(player -> player.getName().equals(viewerName))
                .map(Player::getPosition)
                .findFirst()
                .orElse(-1);
    }

    public static void printResult(Players players, List<String> kindOfResults) {
        final String viewerName = InputView.inputViewerName();

        System.out.println("\n실행결과");

        if ("all".equals(viewerName)) {
            printAllResult(players, kindOfResults);
            return;
        }

        int result = findViewerPosition(players,viewerName);
        System.out.println(kindOfResults.get(result));
    }

}
