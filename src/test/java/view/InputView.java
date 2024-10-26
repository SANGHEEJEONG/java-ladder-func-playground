package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static List<String> splitString(String string) {
        return Arrays.asList(string.split(","));
    }

    public static String inputNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return input.nextLine();
    }

    public static String inputLadderResults(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return input.nextLine();
    }

    public static int inputWidth(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return input.nextInt();
    }

    public static int inputHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = input.nextInt();
        input.nextLine();
        return height;
    }

    public static String inputViewerName(){
        System.out.println("결과를 보고 싶은 사람은?");
        return input.nextLine();
    }
}
