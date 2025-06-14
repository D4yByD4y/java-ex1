package chapter_03;

public class Ex39ForEachEx {
    public static void main(String[] args) {
        int[] n = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for(int k : n) {    // k는 n[0], n[1], ..., n[4]로 반복 (for-each 문)
            System.out.print(k + " ");
            sum += k;
        }
        System.out.println("합은 " + sum);
        
        String[] f = { "사과", "배", "바나나", "체리", "딸기", "포도"};
        for(String s : f) { // s는 f[0], f[1], ..., f[5]로 반복 (for-each 문문)
            System.out.print(s + " ");
        }
    }
}
