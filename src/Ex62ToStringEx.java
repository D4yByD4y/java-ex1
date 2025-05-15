class Point3 {
    private int x, y;
    public Point3(int x, int y) {
        this.x = x; this.y = y;
    }
    public String toString() { // Point3 객체를 문자열로 리턴하는 toString()
        return "Point(" + x + "," + y + ")";
    }
}


public class Ex62ToStringEx {
    public static void main(String[] args) {
        Point3 a = new Point3(2, 3);
        System.out.println(a.toString());
        System.out.println(a);
    }
}
