package chapter_03;
import java.util.Scanner;

public class Ex36BreakExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("exit을 입력하면 종료합니다.");
        while (true) {
            System.out.print(">>");
            String text = scanner.nextLine();
            if (text.equals("exit")) {
                break; // while문을 벗어남
            }
        }
        System.out.println("종료합니다...");
        scanner.close();
    }
}
