package chapter_02;

public class Ex21Hello {
    public static int sum(int n, int m) {
        return n + m;
    }

    // main() 메소드에서 실행 시작작
    public static void main(String[] args) {
        int i = 20;
        int s;
        char a;

        s = sum(i, 10); // 메소드 호출출
        a = '?';
        System.out.println(a);  // 문자 '?' 출력
        System.out.println("Hello");    // "Hello" 문자열 출력
        System.out.println(s);  // 정수 s 값 30 출력
    }
}
