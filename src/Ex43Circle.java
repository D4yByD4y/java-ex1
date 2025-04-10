public class Ex43Circle {
    int radius;
    String name;

    public Ex43Circle() {   // 매개 변수 없는 생성자(클래스 이름과 동일)
        radius = 1;         // radius의 초기값은 1
        name = "";
    }

    public Ex43Circle(int r, String n) {    // 매개 변수를 가진 생성자
        radius = r;     // 생성자는 radius와 name 필드 초기화
        name = n;
    }

    public double getArea() {
        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Ex43Circle pizza = new Ex43Circle(10, "자바피자");  // Circle 객체 생성, 반지름 10
        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area);

        Ex43Circle donut = new Ex43Circle();    // Circle 객체 생성, 반지름 1
        donut.name = "도넛피자";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);
    }
}
