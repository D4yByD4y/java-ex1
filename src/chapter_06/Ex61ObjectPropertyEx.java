package chapter_06;
class Ex61Point {
    private int x, y;
    public Ex61Point(int x, int y) {
        this.x = x; this.y = y;
    }
}

public class Ex61ObjectPropertyEx {
    public static void main(String[] args) {
        Ex61Point p = new Ex61Point(2, 3);
        System.out.println(p.getClass().getName());
        System.out.println(p.hashCode());
        System.out.println(p.toString());
    }
}
