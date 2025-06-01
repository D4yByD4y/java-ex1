package chapter_05;

interface Ex57phoneInterface {  // 인터페이스 선언
    final int TIMEOUT = 10000; // 상수 필드 선언
    void sendCall(); // 추상 메소드
    void receiveCall(); // 추상 메소드
    default void printLogo() { // default 메소드
        System.out.println("** Phone **");
    }
}

class Ex57Calc {    // 클래스 작성
    public int calculate(int x, int y) {
        return x + y;
    }
}

// Ex57SmartPhone 클래스는 Ex57Calc를 상속받고, Ex57phoneInterface 인터페이스의 추상 메소드 모두 구현
class Ex57SmartPhone extends Ex57Calc implements Ex57phoneInterface {
    // Ex57phoneInterface의 추상 메소드 구현
    @Override
    public void sendCall() {
        System.out.println("따르릉따르릉~~");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화 왔어요.");
    }

    // 추가로 작성한 메소드
    public void schedule() {
        System.out.println("일정 관리합니다.");
    }
}

public class Ex57InterfaceEx {
    public static void main(String[] args) {
        Ex57SmartPhone phone = new Ex57SmartPhone();
        phone.printLogo();
        phone.sendCall();
        System.out.println("3과 5를 더하면 " + phone.calculate(3, 5));
        phone.receiveCall();
    }
}
