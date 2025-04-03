# 진재원 202430131

## 4월 3일(5주차)

### for 문

    for(초기문; 조건식; 반복 후 작업) {
        ..작업문..
    }
    ex)
    for(int i = 0; i < 10; i++) {   // 0에서 9까지 출력
        System.out.print(i);
    }
    
    for <무한 반복>
    for(초기문; true; 반복 후 작업) {
        ...........
    }
    
    for <무한 반복2>
    for(초기문; ; 반복 후 작업) {
        ...........
    }

    반복 횟수를 카운팅 함.
    반복 횟수가 "정해져 있을 때" 많이 사용함.

### while 문
    while(조건식) {
        .. 작업문 ..
    }
    ex)
    int i = 0;          // for문과 달리 초기문을 while문 밖에 적어야함.
    while(i < 10) {     // 0에서 9까지 출력
        System.out.print(i);
        i++;
    }

    반복 횟수가 "정해져 있지 않을 때" 많이 사용함.
    조건식에 특정 조건을 집어넣고 그 조건을 만족하면 while 문을 벗어나게 할 수도 있음.

    ex)
    while((n = scanner.nextInt()) != 0) {   // 0이 입력되면 while 문 벗어남
        ............
    }

### do-while 문
    do {
        .. 작업문 ..
    } while(조건식)

    ex)
    int i = 0;
    do { // 0에서 9까지 출력
        System.out.print(i);
        i++
    } while(i < 10);

    기본적으로 while 문과 동일하지만 처음에 조건식을 따지지 않으므로 작업문이 "적어도" 한번은 실행되는 특징이 있음.

### 중첩 반복
    반복문 안에 다른 반복문을 만들 수 있음.
    for 문 안에 for 문이나 while 문을 둘 수도 있고, while 문 안에 for 문, while 문, do-while 문을 둘 수 있음.
    
    ex)
    for(int i = 0; i < 100; i++) {
        for(int j = 0; j < 1000; j++) {
            ...
            ...
        }
        ...
    }
    예시로는 구구단을 출력할 때 중첩 반복(2중)을 사용함.

### continue / break
    반복문과 함께 사용되면서 반복의 흐름을 바꾸거나 반복에서 벗어나게 하는 중요한 기능을 함.

### continue
    반복문을 빠져나가지 않으면서 즉시 다음 반복으로 넘어가고자할 때 사용함.

    1.
    for(초기문; 조건식; 반복 후 작업) {
        ......
        continue;   // 반복 후 작업으로 분기함.
        ......
    }

    2.
    while(조건식) {
        ......
        continue;   // 조건식을 검사하는 과정으로 분기함.
        ......
    }

    3.
    do{
        ......
        continue;   // while문과 같음.
        ......
    } while(조건식)

### break
    하나의 반복문을 즉시 벗어날 때 사용함.
    1. 하나의 반복문을 벗어나는 경우

    for(초기문; 조건식; 반복 후 작업) {
        ......
        break;  // for 문을 벗어남.
        ......
    }
    ...... // 즉, 여기에서 시작

    2. 중첩 반복에서 안쪽 반복문만 벗어나는 경우
    for(초기문; 조건식; 반복 후 작업) {
        while(조건식) {
            ......
            break; // while 문을 벗어나고 for 문에서 실행을 유지함.
            ......
        }
        ...... // 즉, 여기에서 시작
    }
    ......

### 배열
    인덱스(index)와 그에 대응하는 데이터들로 이루어진 연속적인 자료 구조
    같은 종류의 데이터들이 순차적으로 저장됨.

    1. 선언
    레퍼런스 변수를 선언하는 것으로 배열 공간이 생성되지 않음.
    레퍼런스라고 불리는 배열의 주소 값을 가지는 상태일 뿐임.
    c언어의 포인터라고 생각하면 이해하기 쉬움.
    int intArray[];

    선언 시 [] 안에 배열 크기를 지정하면 안됨.
    int intArray[5];

    2. 생성
    배열 공간을 할당받는 과정
    new 연산자를 이용하여 배열을 생성하며 [] 안에 생성할 원소 개수 지정
    intArray = new int[5]; // 5개의 정수 배열 할당

    3. 선언 및 생성
    int intArray[] = new int[5] // 배열 선언과 동시에 배열 생성

    4. 초기화
    선언문에서 { } 사이에 원소를 나열하여 초기화된 배열 만들 수 있음.
    int intArray[] = {4, 3, 2, 1, 0}; // 크기는 자동으로 5가 됨.
    배열의 크기는 { } 사이에 나열된 값의 개수로 정해짐.

    5. 인덱스 / 원소 접근
    인덱스는 0 이상의 양의 정수만 가능함.
    마지막 원소의 인덱스는 (배열 크기 - 1)

    int intArray = new int[5] // 인덱스는 0~4까지 가능
    intArray[0] = 5; // 원소 0에 5 저장
    intArray[3] = 6; // 원소 3에 6 저장
    int n = intArray[3]; // 원소 3의 값인 6을 n에 저장

    ※ 오류
    int n = intArray[-2]; // 인덱스는 음수 사용 불가
    int m = intArray[5]; // intArray의 마지막 인덱스는 5이므로 범위 초과

    ※ 오류2
    int intArray[]; // 레퍼런스만 선언
    intArray[1] = 8; // 배열이 생성되어 있지 않아 불가능.

    6. 치환 / 배열 공유
    자바는 배열 공간과 레퍼런스 변수가 분리되어 있기에 생성된 배열의 공유가 쉽게 이루어짐.

    int intArray[] = new int[5]; // 선언과 생성
    int myArray[] = intArray; // 레퍼런스 치환, 쉽게 말해 myArray도 intArray와 동일한 배열의 주소값을 가짐.


### 배열의 크기, length 필드
    자바는 배열을 객체로 다룸.
    배열이 생성되면 배열 공간과 배열의 크기 값을 가진 length 필드가 배열 객체 내에 생성됨.
    length 필드를 사용하면 배열의 크기를 쉽게 알아낼 수 있음.

    int intArray[] = new int[5];
    int size = intArray.length; // size = 5

    for(int i = 0; i < intArray.length; i++) { // intArray 배열 크기만큼 루프
        System.out.print(intArray[i]);
    }

### for-each 문
    배열이나 나열의 원소를 순차 접근하기에 유용함.
    
    for(변수 : 배열레퍼런스) {
        .. 반복작업문 ..
    }

    ex)
    int n[] = {1, 2, 3, 4, 5};
    int sum = 0;
    for(int k : n) { // n.length 만큼 반복
        // 반복될 때마다 k는 n[0], ... n[4]로 설정
        sum += k;
    }

### 2차원 배열
    1. 선언
    int intArray[][]; || int[][] intArray;

    2. 생성
    intArray = new int[2][5]; // 2행 5열(2x5)의 2차원 배열 생성

    * 첫번째 []는 행의 개수이고 두번째 []는 열의 개수임.

    3. 선언 및 생성
    int intArray[][] = new int[2][5];

    4. 초기화
    배열을 선언할 때 원소를 초기화할 수 있음.
    int intArray[][] = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} } // 3x3 배열 생성

    5. 구조
    int i[][] = new int[2][5];
    int size1 = i.length; // 2차원 배열의 행의 개수 = 2
    int size2 = i[0].length; // 0번째 행의 열의 개수 = 5
    int size3 = i[1].length; // 1번째 행의 열의 개수 = 5

### 메소드의 배열 리턴
    배열의 레퍼런스(주소)만 리턴됨.
    리턴하는 배열 타입과 리턴 받는 배열 타입이 일치해야 함.
    리턴 타입에 배열의 크기는 지정하지 않음.

    ex)
    int[] intArray;

    int[] makeArray() {
        int temp[] = new int[4];
        return temp;
    }

    intArray = makeArray(); // temp 값(주소) 치환

    for(int i = 0; i < intArray.length; i++) { // 마음대로 사용 가능
        intArray[i] = i;
    }


## 3월 27일(4주차)

### 가비지 컬렉션
    자바 언어는 메모리 할당 기능 O / 메모리 반환 기능 X
    사용하지 않는 메모리는 JVM에 의해 자동 반환됨.

### 실행 속도 계선을 위한 JIT 컴파일러 사용
    자바는 바이트 코드를 인터프리터 방식으로 실행함.
    기계어가 실행되는 것보다는 느림.
    JIT 컴파일 기법으로 실행 속도가 개선됨.

---
## 소스 코드, 바이트 코드, 기계어

### 1. 소스코드(Source code)
    우리가 작성하는 Java 코드 (.Java 파일)
    사람이 읽을 수 있는 고급 언어

### 2. 바이트코드(Bytecode, .class 파일)
    Java 컴파일러(javac)가 소스코드를 변환한 중간 코드
    CPU가 직접 실행 불가능 => JVM이 실행해야 함.
    기계어와 다르게 플랫폼에 독립적임.
    바이트코드는 JVM이 해석(인터프리터)하거나, JIT 컴파일러가 기계어로 변환하여 실행됨.

### 3. 기계어(Machine Code)
    CPU가 직접 실행할 수 있는 0과 1의 이진 코드
    운영체제(OS)와 CPU 아키텍처(Intel, ARM 등)에 따라 다르게 실행됨.
    16진수 형태의 기계어

### 4. 바이트코드와 기계어의 차이점
    바이트코드는 JVM이 실행하는 중간 코드 ==> 운영체제와 CPU에 관계없이 사용 O
    기계어는 CPU가 직접 실행하는 코드 ==> 특정 하드웨어에 종속됨.

---
## System.out.print의 종류

### 1. System.out.print( )
    기본 출력문
    줄 바꿈을 하지 않고 한 줄로 출력함.
    줄 바꿈을 하려면 개행 문자 \n(new line)를 넣어야 함.

### 2. System.out.println( )
    출력 후 자동으로 줄 바꿈(개행)을 실행함.
    개행 문자 없이 자동으로 줄 바꿈이 되기 때문에 자주 사용함.
    print + line

### 3. System.out.printf( )
    형식을 지정(formatting)하여 문자열을 출력할 때 사용함.
    값을 특정한 형식(소수점 자리 수, 정렬 등)으로 출력할 때 유용함.

---

## System.in vs. Scanner
### 1. System.in
    키보드와 연결된 자바의 표준 입력 스트림
    입력되는 키를 바이트로 리턴하는 저수준 스트림
    System.in을 직접 사용하면 바이트를 문자나 숫자로 변환하는 많은 어려움이 있음.

### 2. Scanner 클래스
    읽은 바이트를 문자, 정수, 실수, 불린, 문자열 등 다양한 타입으로 변환하여 리턴함.
    ### java.util.Scanner
    객체를 생성해서 사용함.
    키보드에 연결된 System.in에게 키를 읽게 하고, 원하는 타입으로 변환하여 리턴함.
    입력되는 키 값을 공백으로 구분되는 토큰 단위로 읽음.
    공백 문자 : '\t', '\r', '\n', ' ', '\f' ...

---
