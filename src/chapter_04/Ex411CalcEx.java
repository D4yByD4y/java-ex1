package chapter_04;
class Ex411Calc {
    public static int abs(int a) { return a > 0? a: -a;}
    public static int max(int a, int b) { return (a > b)? a: b;}
    public static int min(int a, int b) { return (a > b)? b: a;}
}

public class Ex411CalcEx {
    public static void main(String[] args) {
        System.out.println(Ex411Calc.abs(-5));
        System.out.println(Ex411Calc.max(10, 8));
        System.out.println(Ex411Calc.min(-3, -8));
    }
}
