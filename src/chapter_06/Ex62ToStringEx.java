package chapter_06;
class Ex62Point {
    private int x, y;
    public Ex62Point(int x, int y) {
        this.x = x; this.y = y;
    }
    public String toString() { // Point3 객체를 문자열로 리턴하는 toString()
        return "Point(" + x + "," + y + ")";
    }
}


public class Ex62ToStringEx {
    public static void main(String[] args) {
        Ex62Point a = new Ex62Point(2, 3);
        System.out.println(a.toString());
        System.out.println(a);
    }
}
