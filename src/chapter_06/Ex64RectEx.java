package chapter_06;
class Ex64Rect {
    private int width, height;

    public Ex64Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) { // 사각형 면적 비교
        Ex64Rect p = (Ex64Rect) obj;    // obj를 Ex64Rect로 다운 캐스팅
        if (width*height == p.width*p.height) return true;
        else return false;
    }
}

public class Ex64RectEx {
    public static void main(String[] args) {
        Ex64Rect a = new Ex64Rect(2, 3); // 면적 6
        Ex64Rect b = new Ex64Rect(3, 2); // 면적 6
        Ex64Rect c = new Ex64Rect(3, 4); // 면적 12

        if (a.equals(b)) {
            System.out.println("a is equal to b");
        }
        if (a.equals(c)) {
            System.out.println("a is equal to c");
        }
        if (b.equals(c)) {
            System.out.println("b is equal to c");
        }
    }
}
