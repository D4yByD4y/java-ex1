class Rect1 {
    private int width, height;

    public Rect1(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        Rect1 p = (Rect1) obj;
        if (width*height == p.width*p.height) return true;
        else return false;
    }
}

public class Ex64RectEx {
    public static void main(String[] args) {
        Rect1 a = new Rect1(2, 3); // 면적 6
        Rect1 b = new Rect1(3, 2); // 면적 6
        Rect1 c = new Rect1(3, 4); // 면적 12

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
