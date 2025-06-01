package chapter_05;
class Ex52Point {
    private int x, y;
    public Ex52Point() { // 한 점을 구성하는 x, y 좌표
        this.x = this.y = 0;
    }
    public Ex52Point(int x, int y) {
        this.x = x; this.y = y;
    }
    public void showPoint() { // 점의 좌표 출력
        System.out.println("(" + x + "," + y + ")");
    }
}

class Ex52ColorPoint extends Ex52Point { // Point1을 상속받은 ColorPoint1 선언
    private String color; // 점의 색
    public Ex52ColorPoint(int x, int y, String color) {
        super(x, y); // Point1의 생성자 Point1(x, y) 호출
        this.color = color;
    }
    public void showColorPoint() { // 컬러 점의 좌표 출력
        System.out.print(color);
        showPoint(); // Point1 클래스의 showPoint() 호출
    }
}

public class Ex52SuperEx {
    public static void main(String[] args) {
        Ex52ColorPoint cp = new Ex52ColorPoint(5, 6, "blue");
        cp.showColorPoint();
    }    
}
