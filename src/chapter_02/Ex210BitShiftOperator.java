package chapter_02;

public class Ex210BitShiftOperator {
    public static void main(String[] args) {
        short a = (short)0x55ff;
        short b = (short)0x00ff;
        // 비트 연산
        System.out.println("[비트 연산 결과]");
        System.out.printf("%04x\n", (short)(a & b));    // 비트 AND
        System.out.printf("%04x\n", (short)(a | b));    // 비트 OR
        System.out.printf("%04x\n", (short)(a ^ b));    // 비트 XOR
        System.out.printf("%04x\n", (short)(~a));   // 비트 NOT

        byte c = 20;    // 0x14
        byte d = -8;    // 0xf8
        // 시프트 연산
        System.out.println("[시프트 연산 결과]");
        System.out.println(c << 2); // c를 2비트 왼쪽 시프트 (c에 4를 곱한 결과가 나타남남)
        System.out.println(c >> 2); // c를 2비트 오른쪽 시프트. 0 삽입 (c가 양수이므로 시프트 시에 0 삽입. 나누기 4 효과)
        System.out.println(d >> 2); // d를 2비트 오른쪽 시프트. 1 삽입 (d가 음수이므로 시프트 시에 1 삽입. 나누기 4 효과과)
        System.out.printf("%x\n", (d >>> 2));   // d를 2비트 오른쪽 시프트. 0 삽입 (시프트 시에 최상위 비트에 0 삽입. 나누기 효과는 나타나지 않음)
        // d(0xf8)는 시프트 연산 전에 int 타입으로 바뀌어 32비트의 fffffff8이 된다. 그러고 나서 >>> 연산이 이루어지면 0이 2번 삽입되어 3ffffffe가 된다.
    }
}
