class Shape { // 도형의 슈퍼 클래스
    public void draw() {
        System.out.println("Shape");
    }
}
class Line extends Shape {
    @Override
    public void draw() { // 메소드 오버라이딩
        System.out.println("Line");
    }
}
class Rect extends Shape {
    @Override
    public void draw() { // 메소드 오버라이딩
        System.out.println("Rect");
    }
}
class Circle1 extends Shape {
    @Override
    public void draw() { // 메소드 오버라이딩
        System.out.println("Circle");
    }
}

public class Ex54MethodOverridingEx {
    static void paint(Shape p) { // Shape을 상속받은 모든 객체들이 매개 변수로 넘어올 수 있음
        p.draw(); // p가 가리키는 객체에 오버라이딩한 draw() 호출. 동적 바인딩
    }
    public static void main(String[] args) {
        Line line = new Line();
        paint(line); // Line의 draw() 실행. "Line" 출력

        // 다음 호출들은 모두 paint() 메소드 내에서 Shape에 대한 레퍼런스 p로 업캐스팅됨
        paint(new Shape()); // Shape의 draw() 실행. "Shape" 출력
        paint(new Line()); // 오버라이딩된 메소드 Line의 draw() 실행, "Line" 출력
        paint(new Rect()); // 오버라이딩된 메소드 Rect의 draw() 실행, "Rect" 출력
        paint(new Circle1()); // 오버라이딩된 메소드 Circle의 draw() 실행, "Circle" 출력
    }
}
