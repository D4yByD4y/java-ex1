package chapter_03;
public class Ex31ForSample {
    public static void main(String[] args) {
        int i, sum = 0;

        for (i = 1; i <= 10; i++) {
            sum += i;
            System.out.print(i);
            
            if (i <= 9) {
                System.out.print("+");
            } 
            else {
                System.out.print("=");
                System.out.print(sum);    
            }
        }
        
    }
}
