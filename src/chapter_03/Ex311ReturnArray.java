package chapter_03;

public class Ex311ReturnArray {
    static int[] makeArray() {  // 일차원 정수 배열 리턴
        int[] temp = new int[4];    // 배열 생성
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;    // 배열 초기화, 0, 1, 2, 3
        }
        return temp;    // 배열 리턴
    }

    public static void main(String[] args) {
        int[] intArray; // 배열 레퍼런스 변수 선언
        intArray = makeArray();    // 메소드가 리턴한 배열 참조 (intArray는 makeArray()가 리턴한 배열을 가리킴)
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }
}
