package chapter_06;
class Point2 {
    private int x, y;
    public Point2(int x, int y) {
        this.x = x; this.y = y;
    }
}

public class Ex61ObjectPropertyEx {
    public static void main(String[] args) {
        Point2 p = new Point2(2, 3);
        System.out.println(p.getClass().getName());
        System.out.println(p.hashCode());
        System.out.println(p.toString());
    }
}
