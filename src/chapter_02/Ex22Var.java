package chapter_02;

public class Ex22Var {
    public static void main(String[] args) {
        var price = 200;    // price는 int 타입으로 결정
        var name = "JaeWon";    // name은 String 타입으로 결정
        var pi = 3.14;  // pi는 double 타입으로 결정

        System.out.println("price = " + (price + 1000));
        System.out.println("name = " + name);
        System.out.println("pi = " + pi);
    }
}
