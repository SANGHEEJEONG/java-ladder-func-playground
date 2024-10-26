package view;

import domain.Ladder;
import domain.Line;

import java.util.List;
import java.util.Map;

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

    public static void printSelectedResult(String viewerName, Map<String, String> resultMap) {
        System.out.println("\n실행결과");
        System.out.println(resultMap.get(viewerName));
    }

    public static void printResult(Map<String, String> resultMap, String viewerName) {
        System.out.println("\n실행결과");

        if ("all".equals(viewerName)) {
            resultMap.forEach((player, result) -> System.out.println(player + " -> " + result));
            return;
        }

        String result = resultMap.getOrDefault(viewerName, "존재하지 않는 플레이어입니다.");
        System.out.println(result);
    }

}
