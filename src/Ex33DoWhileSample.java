public class Ex33DoWhileSample {
    public static void main(String[] args) {
        char a = 'a';

        do {
            System.out.print(a);
            a = (char) (a + 1);
        } while (a <= 'z');
        // 대문자 A는 10진수 65, 소문자 a는 10진수 97
    }
}
