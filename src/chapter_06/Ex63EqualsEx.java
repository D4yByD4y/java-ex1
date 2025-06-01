package chapter_06;
class Ex63Point {
    int x, y;
    public Ex63Point(int x, int y) {
        this.x = x; this.y = y;
    }
    public boolean equals(Object obj) {
        Ex63Point p = (Ex63Point)obj; // obj를 Ex63Point 타입으로 다운 캐스팅
        if(x == p.x && y == p.y) return true;
        else return false;
    }
}

public class Ex63EqualsEx {
    public static void main(String[] args) {
        Ex63Point a = new Ex63Point(2, 3);
        Ex63Point b = new Ex63Point(2, 3);
        Ex63Point c = new Ex63Point(3, 4);
        if(a == b) System.out.println("a==b");
        if(a.equals(b)) System.out.println("a is equal to b");
        if(a.equals(c)) System.out.println("a is equal to c");
    }
}
