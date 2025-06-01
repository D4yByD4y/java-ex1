package chapter_04;

public class Ex49GarbageEx {
    public static void main(String[] args) {
        String a = new String("Good!");
        String b = new String("Bad");
        String c = new String("Normal");
        String d, e;
        a = null;
        d = c;
        c = null;
    }
}
