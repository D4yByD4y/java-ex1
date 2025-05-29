package chapter_04;
public class Ex41Circle {
    int radius;     // 원의 반지름 필드(멤버 변수)
    String name;    // 원의 이름 필드(멤버 변수)

    public double getArea() {   // 메소드(멤버 함수)
        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Ex41Circle pizza;   // 객체에 대한 레퍼런스 변수 pizza 선언
        pizza = new Ex41Circle();       // Circle 객체 생성
        pizza.radius = 10;              // 피자의 반지름을 10으로 설정
        pizza.name = "자바피자";        // 피자의 이름 설정
        double area = pizza.getArea();  // 피자의 면적 알아내기
        System.out.println(pizza.name + "의 면적은 " + area);

        Ex41Circle donut = new Ex41Circle();    // Circle 객체 생성
        donut.radius = 2;           // 도넛의 반지름을 2로 설정
        donut.name = "자바도넛";    // 도넛의 이름 설정
        area = donut.getArea();     // 도넛의 면적 알아내기
        System.out.println(donut.name + "의 면적은 " + area);
        
    }
}
