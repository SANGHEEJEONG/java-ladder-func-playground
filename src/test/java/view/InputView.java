package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static int inputWidth(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return input.nextInt();
    }

    public static int inputHeight(){
        System.out.println("사다리의 높이는 몇 개인가요?");
        return input.nextInt();
    }
}
