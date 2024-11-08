package view;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Point;

import java.util.List;

public class OutputView {

    // 플레이어 이름 출력
    public static void printPlayers(List<String> names) {
        System.out.println("\n사다리 결과\n");
        names.forEach(System.out::print);
        System.out.println();
    }

    private static String changeValueToView(Point point) {
        if (point.isEnabled())
            return "-----";

        return "     ";
    }

    private static void drawLine(Line line) {
        line.getLine().forEach(point -> System.out.print("|" + changeValueToView(point)));
        System.out.println("|");
    }

    // 사다리 출력
    public static void drawLadder(Ladder ladder) {
        ladder.getLadder().forEach(OutputView::drawLine);
    }

    // 결과 종류 출력
    public static void printResultTypes(List<String> resultTypes) {
        resultTypes.forEach(System.out::print);
        System.out.println();
    }

    public static void printAllResult(Players players, List<String> resultTypes) {
        for (Player player : players.getPlayers()) {
            System.out.println(player.getPlayerName() + " : " + resultTypes.get(player.getPosition()));
        }
    }

    // 보고 싶은 사다리 결과 출력
    public static void printResult(Players players, List<String> resultTypes) {
        String viewerName = InputView.inputViewerName();

        System.out.println("\n실행결과");

        if ("all".equals(viewerName)) {
            printAllResult(players, resultTypes);
            return;
        }

        Player player = players.findByName(viewerName);
        System.out.println(resultTypes.get(player.getPosition()));
    }
}
