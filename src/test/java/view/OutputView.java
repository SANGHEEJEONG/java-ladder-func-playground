package view;

import domain.Ladder;
import domain.Line;

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
        for (String name : names) {
            System.out.print(name);
        }
    }

    public static void printKindOfResults(List<String> kindOfResults) {
        for (String kind : kindOfResults) {
            System.out.print(kind);
        }
        System.out.println();
    }

    public static void drawLadder(Ladder Ladder) {
        System.out.println("\n사다리 결과\n");
        for (Line lines : Ladder.getLadder()) {
            drawLine(lines);
        }
    }

    public static void printAllResult(List<Integer> result) {
        System.out.println("\n실행결과");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + " -> " + result.get(i));
        }
    }
}
