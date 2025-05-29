package chapter_06;
public class Ex68MathEx {
    public static void main(String[] args) {
        System.out.println(Math.abs(-3.14)); // 절댓값 구하기
        System.out.println(Math.sqrt(9.0)); // 제곱근
        System.out.println(Math.exp(2)); // e의 2승
        System.out.println(Math.round(3.14)); // 반올림

        // [1, 45] 사이의 정수형 난수 5개 발생
        System.out.print("이번주 행운의 번호는 ");
        for (int i = 0; i < 5; i++) {
            System.out.print((int)(Math.random()* 45 + 1) + " "); // 난수 발생
        }
    }
}
