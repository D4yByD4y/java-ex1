package chapter_04;
import java.util.Scanner;

class Ex42Rectangle {
    int width;
    int height;
    public int getArea() {
        return width*height;
    }
}

public class Ex42RectApp {
    public static void main(String[] args) {
        Ex42Rectangle rect = new Ex42Rectangle();   // 객체 생성
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        rect.width = scanner.nextInt();
        rect.height = scanner.nextInt();
        System.out.println("사각형의 면적은 " + rect.getArea());
        scanner.close();
    }
}
