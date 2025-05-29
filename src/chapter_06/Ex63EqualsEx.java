package chapter_06;
class Point4 {
    int x, y;
    public Point4(int x, int y) {
        this.x = x; this.y = y;
    }
    public boolean equals(Object obj) {
        Point4 p = (Point4)obj; // obj를 Point4 타입으로 다운 캐스팅
        if(x == p.x && y == p.y) return true;
        else return false;
    }
}

public class Ex63EqualsEx {
    public static void main(String[] args) {
        Point4 a = new Point4(2, 3);
        Point4 b = new Point4(2, 3);
        Point4 c = new Point4(3, 4);
        if(a == b) System.out.println("a==b");
        if(a.equals(b)) System.out.println("a is equal to b");
        if(a.equals(c)) System.out.println("a is equal to c");
    }
}
