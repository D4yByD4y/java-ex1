package chapter_07;

class Ex76GStack<T> {   // 제네릭 스택 선언, 제네릭 타입 T
    int tos;
    Object[] stack;  // 스택에 저장된 요소의 개수 (T[] stack;로 할 수 없음)
    public Ex76GStack() {
        tos = 0;
        stack = new Object[10];  // new T[10];로 할 수 없음. 제네릭 타입의 배열 생성 불가
    }
    public void push(T item) {
        if(tos == 10) { // 스택이 꽉 차서 더 이상 요소를 삽입할 수 없음
            return;
        }
        stack[tos] = item;
        tos++;
    }
    public T pop() {
        if(tos == 0) {  // 스택이 비어 있어 꺼낼 요소가 없음
            return null;
        }
        tos--;
        return (T)stack[tos];   // 타입 매개 변수 타입으로 캐스팅
    }
}

public class Ex76MyStack {
    public static void main(String[] args) {
        Ex76GStack<String> stringStack = new Ex76GStack<String>();  // String 타입의 Ex76GStack 생성
        stringStack.push("seoul");
        stringStack.push("busan");
        stringStack.push("LA");

        for (int i = 0; i < 3; i++) {
            System.out.println(stringStack.pop());  // stringStack 스택에 있는 3개의 문자열 팝
        }

        Ex76GStack<Integer> intStack = new Ex76GStack<Integer>();   // Integer 타입의 Ex76GStack 생성
        intStack.push(1);
        intStack.push(3);
        intStack.push(5);

        for (int i = 0; i < 3; i++) {
            System.out.println(intStack.pop());
        }
    }
}
