package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static List<String> splitString(String string) {
        return Arrays.asList(string.split(","));
    }

    public static String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return input.nextLine();
    }

    public static String inputLadderResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return input.nextLine();
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = input.nextInt();
        validateHeightSize(height);
        input.nextLine();
        return height;
    }

    public static void validateHeightSize(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public static String inputViewerName() {
        String viewerName;
        while (true) {
            System.out.println("\n결과를 보고 싶은 사람은?");
            viewerName = input.nextLine();
            try {
                validateViewerNameNotBlank(viewerName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("입력 값이 공백일 수 없습니다. 다시 입력해 주세요.");
            }
        }
        return viewerName;
    }

    public static void validateViewerNameNotBlank(String viewerName) {
        if (viewerName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }
}
