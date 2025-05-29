# 진재원 202430131

## 5월 29일(13주차)

### 컨테이너와 컴포넌트
```java
컨테이너
-> 다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트 : java.awt.Container를 상속받음
-> 다른 컨테이너에 포함될 수 있음
-> AWT 컨테이너 : Panel, Frame, Applet, Dialog, Window
-> Swing 컨테이너 : JPanel, JFrame, JApplet, JDialog, JWindow

컴포넌트
-> 컨테이너에 포함되어야 화면에 출력될 수 있는 GUI 객체
-> 다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
-> 모든 GUI 컴포넌트가 상속받는 클래스 : java.awt.Component
-> 스윙 컴포넌트가 상속받는 클래스 : javax.swing.Jcomponent

최상위 컨테이너
-> 다른 컨테이너에 포함되지 않고도 화면에 출력되며, 독립적으로 존재 가능한 컨테이너
-> 스스로 화면에 자신을 출력하는 컨테이너 : JFrame, JDialog, JApplet
```

### Swing GUI 프로그램 만들기
```java
스윙 GUI 프로그램을 만드는 과정
1. 스윙 프레임 만들기
2. main() 메소드 작성
3. 스윙 프레임에 스윙 컴포넌트 붙이기

스윙 프로그램 작성에 필요한 import문
import java.awt.*;             // 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*;       // AWT 이벤트 사용을 위한 경로명
import javax.swing.*;          // 스윙 컴포넌트 클래스들의 경로명
import javax.swing.event.*;    // 스윙 이벤트를 위한 경로명
```

### Swing 프레임
```java
스윙 프레임 : 모든 스윙 컴포넌트를 담는 최상위 컨테이너
-> JFrame을 상속받아 구현
-> 컴포넌트들은 화면에 보이려면 스윙 프레임에 부착되어야 함
-> 프레임을 닫으면 프레임에 부착된 모든 컴포넌트가 보이지 않게 됨

스윙 프레임(JFrame) 기본 구성
-> 프레임 : 스윙 프로그램의 기본 틀
-> 메뉴바 : 메뉴들이 부착되는 공간
-> 컨텐트팬 : GUI 컴포넌트들이 부착되는 공간
```

### 프레임 만들기, JFrame 클래스 상속
```java
스윙 프레임
-> JFrame 클래스를 상속받은 클래스 작성
-> 프레임의 크기 반드시 지정 : setSize() 호출
-> 프레임을 화면에 출력하는 코드 반드시 필요 : setVisible(true) 호출
```

### Swing 응용프로그램에서 main()의 기능과 위치
```java
스윙 응용프로그램에서 main()의 기능 최소화 바람직
-> 스윙 응용프로그램이 실행되는 시작점으로서의 기능만
-> 스윙 프레임을 생성하는 정도의 코드로 최소화

public static void main(String[] args) {
    MyFrame frame = new MyFrame(); // 스윙 프레임 생성 
}

# frame 객체를 생성하고 사용하지 않기 때문에 worrying이 발생
# 실무에서는 다음과 같이 코딩하는 것이 일반적 ↓

public static void main(String[] args) {
    new MyFrame();
}
```

### 프레임에 컴포넌트 붙이기
```java
타이틀 달기
-> super()나 setTitle() 이용

MyFrame() { // 생성자
    super("타이틀 문자열");
}

MyFrame() { // 생성자
    setTitle("타이틀 문자열");
}

컨텐트팬에 컴포넌트 달기
-> 컨텐트팬이란? 스윙 컴포넌트들이 부착되는 공간
-> 컨텐트팬 알아내기 : 스윙 프레임에 붙은 디폴트 컨텐프팬 알아내기
public class MyFrame extends JFrame {
    MyFrame() {
        ...
        // 프레임의 컨텐트팬 알아내기
        Container contentPane = getContentPane();
    }
    ...
}

-> 컨텐트팬에 컴포넌트 붙이기
// 버튼 컴포넌트 생성
JButton button = new JButton("Click");
contentPane.add(button);    // 컨텐트팬에 버튼 부착

-> 컨텐트팬 변경
class MyPanel extends JPanel {
    // JPanel을 상속받은 패널을 구현
}
frame.setContentPane(new MyPanel());
```

### Swing 응용프로그램의 종료
```java
응용프로그램 내에서 스스로 종료하는 방법
-> 언제 어디서나 무조건 종료
System.exit(0);

프레임의 오른쪽 상단의 종료버튼(X)이 클릭되면 어떤 일이 일어나는가?
-> 프레임 종료, 프레임 윈도우를 닫음 : 프레임이 화면에서 보이지 않게 됨

프레임이 보이지 않게 되지만 응용프로그램이 종료한 것 아님
-> 키보드나 마우스 입력을 받지 못함
-> 다시 setVisible(true)를 호출하면, 보이게 되고 이전처럼 작동함

프레임 종료버튼이 클릭될 때, 프레임과 함께 프로그램을 종료시키는 방법
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

### 이벤트 기반 프로그래밍
```java
이벤트 기반 프로그래밍(Event Driven Programming)
-> 이벤트의 발생에 의해 프로그램 흐름이 결정되는 방식
->> 이벤트가 발생하면 이벤트를 처리하는 루튼(이벤트 리스너) 실행
->> 실행될 코드는 이벤트의 발생에 의해 전적으로 결정

-> 반대되는 개념 : 배치 실행(batch programming)
->> 프로그램의 개발자가 프로그램의 흐름을 결정하는 방식

-> 이벤트 종류
->> 사용자의 입력 : 마우스 드래그, 마우스 클릭, 키보드 누름 등
->> 센서로부터의 입력, 네트워크로부터 데이터 송수신
->> 다른 응용프로그램이나 다른 스레드로부터의 메시지

이벤트 기반 응용프로그램의 구조
-> 각 이벤트마다 처리하는 리스너 코드 보유

GUI 응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
-> GUI 라이브러리 종류 : C++의 MFC, C# GUI, Visual Basic, X Window, Android 등
-> 자바의 AWT와 Swing
```

### 이벤트 객체
```java
이벤트 객체
-> 발생한 이벤트에 관한 정보를 가진 객체
-> 이벤트 리스너에 전달됨
->> 이벤트 리스너 코드가 발생한 이벤트에 대한 상황을 파악할 수 있게 함

이벤트 객체가 포함하는 정보
-> 이벤트 종류와 이벤트 소스
-> 이벤트가 발생한 화면 좌표 및 컴포넌트 내 좌표
-> 이벤트가 발생한 버튼이나 메뉴 아이템의 문자열
-> 클릭된 마우스 버튼 번호 및 마우스의 클릭 횟수
-> 키의 코드 값과 문자 값
-> 체크박스, 라디오버튼 등과 같은 컴포넌트에 이벤트가 발생하였다면 체크 상태

이벤트 소스를 알아 내는 메소드 : Object getSource()
-> 발생한 이벤트의 소스 컴포넌트 리턴
-> Object 타입으로 리턴하므로 캐스팅하여 사용
-> 모든 이벤트 객체에 대해 적용
```

### 리스너 인터페이스
```java
이벤트 리스너 : 이벤트를 처리하는 자바 프로그램 코드, 클래스로 작성

자바는 다영한 리스터 인터페이스 제공

ex) ActionListener 인터페이스 - 버튼 클릭 이벤트를 처리하기 위한 인터페이스
interface ActionListener {  // 아래 메소드를 개발자가 구현
    public void actionPerformed(ActionEvent e); // Action 이벤트 발생시 호출
}

ex) MouseListener 인터페이스 - 마우스 조작에 따른 이벤트를 처리하기 위한 인터페이스
interface MouseListener {   // 아래 5개 메소드를 개발자가 구현
    public void mousePressed(MouseEvent e); // 마우스 버튼이 눌러지는 순간
    public void mouseReleased(MouseEvent e); // 눌러진 마우스 버튼이 떼어지는 순간
    public void mouseClicked(MouseEvent e); // 마우스가 클릭되는 순간
    public void mouseEntered(MouseEvent e); // 마우스가 컴포넌트 위에 올라가는 순간
    public void mouseExited(MouseEvent e); // 마우스가 컴포넌트 위에서 내려오는 순간
}
```

### 이벤트 리스너 작성 과정 사례
```java
1. 이벤트와 이벤트 리스너 선택
-> 버튼 클릭을 처리하고 하는 경우
->> 이벤트 : Action 이벤트, 이벤트 리스너 : ActionListener

2. 이벤트 리스너 클래스 작성 : ActionListener 인터페이스 구현
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {    // 버튼이 클릭될 때 호출
        JButton b = (JButton)e.getSource(); // 사용자가 클릭한 버튼 알아내기
        if(b.getText().equals("Action")) // 버튼의 현재 문자열이 "Action"인지 비교
            b.setText("액션"); // JButton의 setText()를 호출하여 문자열 변경
        else 
            b.setText("Action");    // JButton의 setText()를 호출하여 문자열 변경
    }
}

3. 이벤트 리스너 등록
-> 이벤트를 받아 처리하고자 하는 컴포넌트에 이벤트 리스너 등록
-> component.addXXXListener(listener)
->> XXX : 이벤트 명, listener : 이벤트 리스너 객체

MyActionListener listener = new MyActionListener(); // 리스너 인스턴스 생성
btn.addActionListener(listener); // 리스너 등록
```

### 이벤트 리스너 작성 방법
```java
[3가지 방법]

독립 클래스로 작성
-> 이벤트 리스너를 완전한 클래스로 작성
-> 이벤트 리스너를 여러 곳에서 사용할 때 적합

내부 클래스(inner class)로 작성
-> 클래스 안에 멤버처럼 클래스 작성
-> 이벤트 리스너를 특정 클래스에서만 사용할 때 적합

익명 클래스(anonymous class)로 작성
-> 클래스의 이름 없이 간단히 리스너 작성
-> 클래스 조차 만들 필요 없이 리스너 코드가 간단한 경우에 적합
```

## 5월 22일(12주차)

### StringBuffer 클래스
```java
buffer : 임시 저장 공간
가변 스트링을 다루는 클래스

StringBuffer 객체 생성
StringBuffer sb = new StringBuffer("java");

String 클래스와 달리 문자열 변경 가능
-> 가변 크기의 버퍼를 가지고 있어 문자열 수정 O
-> 문자열의 수정이 많은 작업에 적합

스트링 조작 사례
StringBuffer sb = new StringBuffer("This");

sb.append(" is pencil."); // sb = "This is pencil."
sb.insert(7, "my"); // sb = "This is my pencil."
sb.replace(8, 10, "your"); // sb = "This is your pencil."
System.out.println(sb); // "This is your pencil." 출력
```

### StringTokenizer 클래스
```java
구분 문자를 기준으로 문자열을 분리하는 클래스
-> 구분 문자(delimiter) : 문자열을 구분할 때 사용되는 문자
-> 토큰(token) : 구분 문자로 분리된 문자열

ex)
String query = "name=kitae&addr=seoul&age=21";
StringTokenizer st = new StringTokenizer(query, "&");
↓ 결과
"name=kitae" // 토큰 1
"addr=seoul" // 토큰 2
"age=21"     // 토큰 3

int count = st.countTokens(); // 토큰 개수 알아내기. count = 3
String token = st.nextToken(); // 다음 토큰 얻어내기. st = "name=kitae"

StringTokenizer로 문자열 분리 사례 ↓
StringTokenizer st = new StringTokenizer(query, "&=");
↓ 결과
"name" // 토큰 1
"kitae" // 토큰 2
"addr" // 토큰 3
"seoul" // 토큰 4
"age" // 토큰 5
"21" // 토큰 6
```

### Math 클래스
```java
기본 산술 연산 메소드를 제공하는 클래스

모든 메소드는 static으로 선언
-> 클래스 이름으로 호출 가능

Math.random() 메소드로 난수 발생
-> random()은 0보다 크거나 같고 1.0보다 작은 실수 난수 발생
-> 1에서 100까지의 랜덤 정수 10개를 발생시키는 코드 사례 ↓
for(int i = 0; i < 10; i++) {
    int n = (int)(Math.random() * 100 + 1); // 1 ~ 100까지의 랜덤 정수 발생
    System.out.println(n);
}

* java.util.Random 클래스를 이용하여 난수 발생 가능
Random r = new Random();
int n = r.nextInt(); // 음수, 양수, 0을 포함하여 자바의 정수 범위의 난수 발생
int m = r.nextInt(100); // 0에서 99 사이(0과 99 포함)의 정수 난수 발생
```

### 컬렉션(collection)
```java
요소(element)라고 불리는 가변 개수의 객체들의 저장소
-> 객체들의 컨테이너라고도 불림
-> 요소의 개수에 따라 크기 자동 조절
-> 요소의 삽입, 삭제에 따른 요소의 위치 자동 이동

고정 크기의 배열을 다루는 어려움 해소
다양한 객체들의 삽입, 삭제, 검색 등의 관리 용이
```

### 컬렉션의 특징
```java
1. 컬렉션은 제네릭(generics) 기법으로 구현

제네릭
-> 특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 클래스나 메소드를 일반화시키는 기법
-> 클래스나 인터페이스 이름에 <E>, <K>, <V> 등 타입 매개변수 포함

제네릭 컬렉션 사례 : 벡터 Vector<E>
-> <E>에서 E에 구체적인 타입을 주어 구체적인 타입만 다루는 벡터로 활용
-> 정수만 다루는 컬렉션 벡터 Vector<Integer>
-> 문자열만 다루는 컬렉션 벡터 Vector<String>

2. 컬렉션의 요소는 객체만 가능
int, char, double 등의 기본 타입으로 구체화 불가

컬렉션 사례 ↓
Vector<int> v = new Vector<int>(); // 컴파일 오류. int는 사용 불가
Vector<Integer> v = new Vector<Integer>(); // 정상 코드
```

### 제네릭의 기본 개념
```java
제네릭
-> JDK 1.5부터 도입(2004년 기점)
-> 모든 종류의 데이터 타입을 다룰 수 있도록 일반화된 타입 매개 변수로 클래스(인터페이스)나 메소드를 작성하는 기법
-> C++의 템플릿(template)과 동일
```

### Vector <-E->의 특성
```java
<E>에 사용할 요소의 특정 타입으로 구체화

배열을 가변 크기로 다룰 수 있게 하는 컨테이너
-> 배열의 길이 제한 극복
-> 요소의 개수가 넘치면 자동으로 길이 조절

요소 객체들을 삽입, 삭제, 검색하는 컨테이너
-> 삽입, 삭제에 따라 자동으로 요소의 위치 조정

Vector에 삽입 가능한 것
-> 객체, null
-> 기본 타입의 값은 Wrapper 객체로 만들어 저장

Vector에 객체 삽입
-> 벡터의 맨 뒤, 중간에 객체 삽입 가능

Vector에서 객체 삭제
-> 임의의 위치에 있는 객체 삭제 가능
```

### Vector 생성
```java
Vector<Integer> v = new Vector<Integer>(); // 정수만 사용 가능한 벡터

int, char, double 등의 기본 타입을 E에 사용할 수 없음.
Vector<int> v = new Vector<int>(); // 오류. int는 사용 불가

문자열만 다루는 벡터
Vector<String> StringVector = new Vector<String>();

용량 초기 설정
Vector<Integer> v = new Vector<Integer>(7); // 초기 용량이 7인 벡터 생성
```

### 벡터 요소 삽입
```java
add() 메소드를 이용하여 벡터의 끝이나 중간에 요소를 삽입
v.add(Integer.valueOf(5));
v.add(Integer.valueOf(4));
v.add(Integer.valueOf(-1));

자동 박싱 기능을 활용하면 위의 코드는 이렇게도 사용 가능
v.add(5);
v.add(4);
v.add(-1);

자동 박싱에 의해 int 타입의 정수는 자동으로 Integer 객체로 변환되어 삽입
but, 벡터 v에는 Integer 외의 다른 타입의 객체 삽입 x
v.add("hello"); // 컴파일 오류. v에는 정수만 삽입 가능

벡터에는 null 삽입 가능. 벡터를 검색할 때 null이 있을 수 있음을 염두해야 함.
v.add(null);

add()를 이용하여 벡터의 중간에 객체 삽입
v.add(2, 100); // v.add(2, Integer.valueOf(100)); 과 동일.

위의 코드는 인덱스 2의 위치에 정수 100을 삽입하고, 기존의 인덱스 2와 그 뒤에 있는 요소들을 모두 한 자리씩 뒤로 이동시킴. 만약 벡터에 1개의 요소밖에 없다면 코드 실행 시 예외 발생.
```

### 벡터 내의 요소 알아내기
```java
get(), elementAt() 메소드 이용
Integer obj = v.get(1); // 벡터의 1번째 요소 얻어내기
int i = obj.intValue(); // obj에 있는 정수를 알아냄. 이 값은 4

자동 언박싱 활용
int i = v.get(1); // 자동 언박싱
```

### 벡터의 크기와 용량 알아내기
```java
벡터의 크기란 벡터에 들어 있는 요소의 개수를 말함.
size() 메소드 이용
벡터의 용량이란 벡터가 수용할 수 있는 현재 크기를 말함.
capacity() 메소드 이용

int len = v.size(); // 벡터의 크기. 벡터에 존재하는 요소 객체의 수
int cap = v.capacity(); // 벡터의 용량
```

### 벡터에서 요소 삭제
```java
remove() 메소드 이용
v.remove(1); // 인덱스 1의 위치에 있는 요소 삭제

위의 코드는 인덱스 1의 위치에 있는 요소를 삭제함.
코드의 실행 결과 뒤에 있는 요소들이 한 자리씩 앞으로 이동함.
객체 레퍼런스를 이용하여 remove() 호출 가능.
Integer m = Integer.valueOf(100);
v.add(m);
...
v.remove(m); // 레퍼런스 m의 요소 삭제

벡터의 모든 요소 삭제
removeAllElements() 메소드 호출
v.removeAllElements();
```

### 컬렉션과 자동 박싱/언박싱
```java
JDK 1.5 이전
-> 기본 타입 데이터를 Wrapper 객체로 만들어 삽입
Vector<Integer> v = new Vector<Integer>();
v.add(Integer.valueOf(4));
-> 컬렉션으로부터 요소를 얻어올 때, Wrapper 클래스로 캐스팅 필요
Integer n = (Integer)v.get(0);
int k = n.intValue(); // k = 4

JDK 1.5부터
-> 자동 박싱/언박싱이 작동하여 기본 타입 값 삽입 가능
Vector<Integer> v = new Vector<Integer>();
v.add(4); // 4 -> Integer.valueOf(4)로 자동 박싱
int k = v.get(0); // Integer 타입이 int 타입으로 자동 언박싱 k = 4
```

### 컬렉션 생성문의 진화 : Java 7, Java 10
```java
Java 7 이전
Vector<Integer> v = new Vector<Integer>(); // Java 7 이전

Java 7 이후
-> 컴파일러의 타입 추론 기능 추가
-> <>(다이아몬드 연산자)에 타입 매개변수 생략
Vector<Integer> v = new Vector<>(); // Java 7부터 추가, 가능

Java 10 이후
-> var 키워드 도입, 컴파일러의 지역 변수 타입 추론 가능
var v = new Vector<Integer>(); // Java 10부터 추가, 가능
```

### ArrayList<-E->
```java
가변 크기 배열을 구현한 클래스
-> <E>에 요소로 사용할 특정 타입으로 구체화

벡터와 거의 동일
-> 요소 삽입, 삭제, 검색 등 벡터 기능과 거의 동일
-> 벡터와 달리 스레드 동기화 기능 없음
-> 다수 스레드가 동시에 ArrayList에 접근할 때 동기화되지 않음
-> 개발자가 스레드 동기화 코드 작성
```

### ArrayList vs Vector
```java
ArrayList와 Vector는 모두 동적으로 크기가 늘어나는 배열 기반의 리스트 클래스

[ArrayList vs Vector 비교 요약]
    항목               ArrayList            |           Vector
동기화 여부       비동기화(스레드 안전 X)        동기화(스레드 안전 O)
    성능          빠름(싱글 스레드에 적합)       느림(동기화로 인한 오버헤드 발생)
기본 크기 증가    1.5배씩 증가                   2배씩 증가
                  (newCapacity = old + old/2)
  도입 시기       Java 1.2                       Java 1.0
사용 권장 여부    현대 개발에서 추천             특별한 이유가 없다면 지양

요즘은 ArrayList가 기본 선택지
Vector는 이제 거의 사용하지 않고, 멀티스레드가 필요하면 다른 방법(synchronizedList, CopyOnWriteArrayList)을 사용
```

### 컬렉션의 순차 검색을 위한 Iterator
```java
Iterator<E> 인터페이스
-> 리스트 구조의 컬렉션에서 요소의 순차 검색을 위한 인터페이스
-> Vector<E>, ArrayList<E>, LinkedList<E>가 상속받는 인터페이스

Iterator 객체 얻어내기
-> 컬렉션의 iterator() 메소드 호출: 해당 컬렉션을 순차 검색할 수 있는 Iterator 객체 리턴
Vector<Integer> v = new Vector<Integer>();
Iterator<Integer> it = v.iterator();

컬렉션 검색 코드
while(it.hasNext()) { // 모든 요소 방문
    int n = it.next(); // 다음 요소 리턴
}
```

### HashMap<K, V>
```java
키(key)와 값(value)의 쌍으로 구성되는 요소를 다루는 컬렉션
-> K : 키로 사용할 요소의 타입
-> V : 값으로 사용할 요소의 타입
-> 키와 값이 한 쌍으로 삽입
-> '값'을 검색하기 위해서는 반드시 '키' 이용

삽입 및 검색이 빠른 특징
-> 요소 삽입 : put() 메소드
-> 요소 검색 : get() 메소드

ex) HashMap<String, String> 생성, 요소 삽입, 요소 검색
HashMap<String, String> h = new HashMap<String, String>(); // 해시맵 객체 생성

h.put("apple", "사과"); // "apple" 키와 "사과" 값의 쌍을 해시맵에 삽입
String kor = h.get("apple"); // "apple" 키로 값 검색. kor는 "사과"
```

### 제네릭 만들기
```java
제네릭 클래스 작성: 클래스 이름 옆에 일반화된 타입 매개 변수 추가
public class MyClass<T> { // 제네릭 클래스 MyClass 선언, 타입 매개 변수 T
    T val; // 변수 val의 타입은 T
    void set(T a) {
        val = a; // T 타입의 값 a를 val에 저장
    }
    T get() {
        return val; // T 타입의 값 val 리턴
    }
}

제네릭 객체 생성 및 활용
MyClass<String> s = new MyClass<String>(); // 제네릭 타입 T를 String으로 구체화
s.set("hello");
System.out.println(s.get()); // "hello" 출력

MyClass<Integer> n = new MyClass<Integer>(); // 제네릭 타입 T를 Integer로 구체화
n.set(5);
System.out.println(n.get()); // 숫자 5 출력
```

### 자바의 GUI
```java
GUI : 사용자가 편리하게 입출력 할 수 있도록 그래픽으로 화면을 구성하고, 마우스나 키보드로 입력 받을 수 있도록 지원하는 사용자 인터페이스

자바 언어에서 GUI 응용프로그램 작성 : AWT와 Swing 패키지에 강력한 GUI 컴포넌트 제공.

[AWT(Abstract Windowing Toolkit) 패키지]
-> 자바가 처음 나왔을 때부터 배포된 GUI 패키지, 최근에는 거의 사용 X
-> AWT 컴포넌트는 중량 컴포넌트(heavy weight component)
-> AWT 컴포넌트의 그리기는 운영체제에 의해 이루어지며, 운영체제의 자원을 많이 소모하고 부담을 줌
-> 운영체제가 직접 그리기 때문에 속도는 빠름

[Swing 패키지]
-> AWT 기술을 기반으로 작성된 자바 라이브러리
-> 모든 AWT + 추가된 풍부하고 화려한 고급 컴포넌트
-> AWT 컴포넌트를 모두 스윙으로 재작성.
-> AWT 컴포넌트 이름 앞에 J자를 덧붙임
-> 순수 자바 언어로 구현
-> 스윙 컴포넌트는 경량 컴포넌트(light weight component)
-> 스윙 컴포넌트는 운영체제의 도움을 받지 않고, 직접 그리기 때문에 운영체제에 부담주지 않음.
-> 현재 자바의 GUI 표준으로 사용됨.
```

## 5월 15일(11주차)

### 모듈
    java 9에서 도입된 개념
    패키지와 이미지 등의 리소스를 담은 컨테이너
    모듈 파일(.jmod)로 저장

### 자바 플랫폼의 모듈화
    자바 플랫폼
    -> 자바의 개발 환경(JDK)과 자바의 실행 환경(JRE)을 지칭. Java SE(자바 API) 포함.
    -> 자바 API의 모든 클래스가 여러 개의 모듈로 재구성
    -> 모듈 파일은 JDK의 jmods 디렉터리에 저장하여 배포

    모듈 파일로부터 모듈을 푸는 명령
    -> jmod extract "C:\Program Files\java\jdk-17.0.3.+7\jmods\java.base.jmod"
    -> 현재 디렉터리에 java.base 모듈이 패키지와 클래스들로 풀림.

### 자바 모듈화의 목적
    자바 컴포넌트들을 필요에 따라 조립하여 사용하기 위함

    컴퓨터 시스템의 불필요한 부담 ↓
    -> 세밀한 모듈화를 통해 필요 없는 모듈이 로드되지 않게 함.
    -> 소형 IoT 장치에도 자바 응용프로그램이 실행되고 성능을 유지되게 함

### Object 클래스
```java
모든 자바 클래스는 반드시 Object를 상속받도록 자동 컴파일
모든 클래스의 슈퍼 클래스
모든 클래스가 상속받는 공통 메소드 포함

주요 메소드
boolean equals(Object obj)
Class getClass()
int hashCode()
String toString()
void notify()
void notifyAll()
void wait()
.
.
.
```

### 객체 속성
```java
Object 클래스는 객체의 속성을 나타내는 메소드 제공

hashCode() 메소드
-> 객체의 해시코드 값을 리턴하며, 객체마다 다름

getClass() 메소드
-> 객체의 클래스 정보를 담은 Class 객체 리턴
-> Class 객체의 getName() 메소드는 객체의 클래스 이름 리턴

toString() 메소드
-> 객체를 문자열로 리턴
```

### 객체 비교(==)와 equals() 메소드
```java
== 연산자: 객체 레퍼런스 비교

Point a = new Point(2,3);
Point b = new Point(2,3);
Point c = a;

if(a == b) // false
    System.out.println("a==b");
if(a == c) // true
    System.out.println("a==c");

boolean equals(Object obj)
-> 두 객체의 내용물 비교
-> 객체의 내용물을 비교하기 위해 클래스의 멤버로 작성
```

### Wrapper 클래스
```java
Wrapper 클래스: 자바의 기본 타입을 클래스화 한 8개 클래스

기본 타입
-> byte, short, int, long, char, float, double, boolean

Wrapper 클래스
-> Byte, Short, Integer, Long, Character, Float, Double, Boolean

용도: 객체만 사용할 수 있는 컬렉션 등에 기본 타입의 값을 사용하기 위해 Wrapper 객체로 만들어 사용

기본 타입의 값으로 Wrapper 객체 생성 (new 키워드 사용 X)
Integer i = Integer.valueOf(10); // 정수 10의 객체화
Character c = Character.valueOf('c'); // 문자 'c'의 객체화
Double d = Double.valueOf(3.14); // 실수 3.14의 객체화
Boolean b = Boolean.valueOf(true); // 불린 값 true의 객체화

문자열로 Wrapper 객체 생성(Character 제외)
Integer i = Integer.valueOf("10");
Double d = Double.valueOf("3.14");
Boolean b = Boolean.valueOf("false");
```

### Wrapper 활용
```java
Wrapper 객체로부터 기본 타입 값 알아내기
Integer i = Integer.valueOf(10);
int ii = i.intValue(); // ii = 10
Character c = Character.valueOf('c');
char cc = c.charValue(); // cc = 'c'
Boolean b = Boolean.valueOf(true);
boolean bb = b.booleanValue(); // bb = true

문자열을 기본 데이터 타입으로 변환
int i = Integer.parseInt("123"); // i = 123
boolean b = Boolean.parseBoolean("true"); // b = true
double d = Double.parseDouble("3.14"); // d = 3.14

기본 타입을 문자열로 변환
String s1 = Integer.toString(123); // 정수 123을 문자열 "123"으로 변환
String s2 = Integer.toHexString(123); // 정수 123을 16진수의 문자열 "7b"로 변환
String s3 = Double.toString(3.14); // 실수 3.14를 문자열 "3.14"으로 변환
String s4 = Character.toString('a'); // 문자 'a'를 문자열 "a"로 변환
String s5 = Boolean.toString(true); // 불린 값 true를 문자열 "true"로 변환
```

### 박싱과 언박싱
```java
박싱(boxing) : 기본 타입의 값 →(변환) Wrapper 객체
언박싱(unboxing) : Wrapper 객체 →(변환) 기본 타입의 값 (박싱의 반대)

Integer ten = Integer.valueOf(10); // 박싱
int n = ten.intValue(); // 언박싱

자동 박싱과 자동 언박싱 : JDK 1.5부터 박싱과 언박싱은 자동으로 이루어지도록 컴파일됨.
Integer ten = 10; // 자동 박싱. Integer ten = Integer.valueOf(10);
int n = ten; // 자동 언박싱. int n = ten.intValue();
```

### String의 생성과 특징
```java
String 클래스는 문자열을 나타냄
스트링 리터럴(문자열 리터럴)은 String 객체로 처리됨

스트링 객체의 생성 사례
String str1 = "abcd";
char data[] = {'a','b','c','d'};
String str2 = new String(data);
String str3 = new String("abcd"); // str2와 str3은 모두 "abcd" 스트링
```

### 스트링 리터럴과 new String()
```java
스트링 리터럴
-> 자바 가상 기계 내부에서 리터럴 테이블에 저장되고 관리
-> 응용프로그램에서 공유됨
-> 스트링 리터럴 사례) String s = "Hello";

new String()으로 생성된 스트링
-> 스트링 객체는 힙 메모리에 생성
-> 스트링은 공유되지 않음

String a = "Hello";
String b = "Java";
String c = "Hello";

String d = new String("Hello");
String e = new String("Java"); 
String f = new String("Java");
```

### 스트링 객체의 특징
```java
리터럴이든 new String()으로 생성했던, 생성된 스트링 객체는 수정이 불가능함
String s = new String("Hello"); // s의 스트링은 수정 불가능
String t = s.concat("Java"); // 스트링 s에 "Java"를 덧붙인 스트링 리턴
```

### String 활용
```java
스트링 비교, equals()와 compareTo()
-> 스트링 비교에 == 연산자 절대 사용 금지
equals() : 스트링이 같으면 true, 아니면 false 리턴
String java = "Java";
if(java.equals("Java")) // true

int compareTo(String anotherString)
-> 문자열이 같으면 0 리턴
-> 이 문자열이 anotherString 보다 먼저 나오면 음수 리턴
-> 이 문자열이 anotherString 보다 나중에 나오면 양수 리턴

String java = "Java";
String cpp = "C++";
int res = java.compareTo(cpp);
if(res == 0) System.out.println("the same");
else if(res < 0) System.out.println(java + " < " + cpp); 
else System.out.println(java + " > " + cpp);

공백 제거, String trim()
스트링 앞뒤에 있는 공백 문자를 제거한 스트링을 리턴

String a = "  xyz\t";
String b = a.trim(); // b = "xyz". 스페이스와 '\t' 제거됨
```


## 5월 8일(10주차)

### 추상 클래스
```java
추상 메소드(abstract method)
-> abstract로 선언된 메소드, 메소드의 코드는 없고 원형만 선언

abstract public String getName(); // 추상 메소드
abstract public String fail() { return "Good Bye"; } // 추상 메소드 아님, 컴파일 오류

추상 클래스(abstract class)
-> 추상 메소드를 가지며, abstract로 선언된 클래스
-> 추상 메소드 없이, abstract로 선언한 클래스

// 추상 메소드를 가진 추상 클래스
abstract class Shape {
    public Shape() { ... }
    public void edit() { ... }

    abstract public void draw(); // 추상 메소드
}

// 추상 메소드 없는 추상 클래스
abstract class JComponent {
    String name;
    public void load(String name) {
        this.name = name;
    }
}

class fault { // 오류. 추상 메소드를 가지고 있으므로 abstract로 선언되어야 함
    abstract public void f(); // 추상 메소드
}
```

### 추상 클래스의 상속과 구현
```java
추상 클래스 상속
-> 추상 클래스를 상속받으면 추상 클래스가 됨
-> 서브 클래스도 abstract로 선언해야 함

abstract class A { // 추상 클래스
    abstract public int add(int x, int y); // 추상 메소드
}

abstract class B extends A { // 추상 클래스
    public void show() { System.out.println("B"); }
}

A a = new A(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
B b = new B(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가

추상 클래스 구현
-> 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현 (오버라이딩)
-> 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님

class C extends A { // 추상 클래스 구현. C는 정상 클래스
    public int add(int x, int y) { return x + y; } // 추상 메소드 구현. 오버라이딩
    public void show() { System.out.println("C"); }
}
...
C c = new C(); // 정상

추상 클래스의 목적
-> 상속을 위한 슈퍼 클래스로 활용하는 것
-> 서브 클래스에서 추상 메소드 구현
-> 다형성 실현
```

### 자바의 인터페이스
```java
소프트웨어를 규격화된 모듈로 만들고, 인터페이스가 맞는 모듈을 조립하듯이 응용프로그램을 작성하기 위해서 사용

자바의 인터페이스
-> 클래스가 구현해야 할 메소드들이 선언되는 추상형
-> 인터페이스 선언: interface 키워드로 선언. Ex) public interface PhoneInterface

interface PhoneInterface {
    public static final int TIMEOUT = 10000; // 상수 필드. public static final 생략 가능
    public abstract void sendCall(); // 추상 메소드. public abstract 생략 가능
    public abstract void receiveCall(); // 추상 메소드. public abstract 생략 가능
    public default void printLogo() { // 디폴트 메소드는 public 생략 가능
        System.out.println(" ** Phone ** ");
    } // 디폴트 메소드
}
```

### 인터페이스 구성 요소들의 특징
```java
[ 인터페이스의 구성 요소들 ]
상수: public만 허용, public static final 생략 가능
추상 메소드: public abstract 생략 가능

default 메소드
-> 인터페이스에 코드가 작성된 메소드
-> 인터페이스를 구현하는 클래스에 자동 상속
-> public 접근 지정만 허용. 생략 가능

private 메소드
-> 인터페이스 내에 메소드 코드가 작성되어야 함
-> 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능

static 메소드
-> public, private 모두 지정 가능. 생략하면 public
```

### 자바 인터페이스의 특징
```java
인터페이스의 객체 생성 불가
new PhoneInterface(); // 오류. 인터페이스 PhoneInterface 객체 생성 불가

인터페이스 타입의 레퍼런스 변수 선언 가능
PhoneInterface galaxy; // galaxy는 인터페이스에 대한 레퍼런스 변수
```

### 인터페이스 상속
```java
인터페이스 간에 상속 가능
-> 인터페이스를 상속하여 확장된 인터페이스 작성 가능
-> extends 키워드로 상속 선언

ex)
interface MobilePhoneInterface extends PhoneInterface {
    void sendSMS(); // 추상 메소드 추가
    void receiveSMS(); // 추상 메소드 추가
}

인터페이스 다중 상속 허용 (* 일반 상속에서는 허용하지 않음)

ex)
interface MusicPhoneInterface extends PhoneInterface, MP3Interface {
    .....
}
```

### 인터페이스 구현
```java
인터페이스의 추상 메소드를 모두 구현한 클래스 작성
-> implements 키워드 사용
-> 여러 개의 인터페이스 동시 구현 가능

인터페이스 구현 사례
-> PhoneInterface 인터페이스를 구현한 SamsungPhone 클래스

class SamsungPhone implements PhoneInterface { // 인터페이스 구현
    // PhoneInterface의 모든 메소드 구현
    public void sendCall() { System.out.println("띠리리리링"); }
    public void receiveCall() { System.out.println("전화가 왔습니다."); }
    // 메소드 추가 작성
    public void flash() { System.out.println("전화기에 불이 켜졌습니다."); }
}

SamsungPhone 클래스는 PhoneInterface의 default 메소드 상속
```

### 자바의 패키지 / 모듈
```java
패키지(package)
-> 서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어 놓은 디렉터리
-> 하나의 응용프로그램은 한 개 이상의 패키지로 작성
-> 패키지는 jar 파일로 압축 가능

모듈(module)
-> 여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
-> 하나의 모듈을 하나의 .jmod 파일에 저장

Java 9부터 모듈화 도입

플랫폼의 모듈화
-> Java 9부터 자바 API의 모든 클래스들(자바 실행 환경)을 패키지 기반에서 모듈들로 완전히 재구성

응용프로그램의 모듈화
-> 클래스들은 패키지로 만들고, 다시 패키지를 모듈로 만듦. 모듈 프로그래밍은 어렵고 복잡.
```

### 패키지 사용하기, import 문
```java
다른 패키지에 작성된 클래스 사용
-> import를 이용하지 않는 경우
-> 소스에 클래스 이름의 완전 경로명 사용

public class ImportExample {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println(scanner.next());
    }
}

필요한 클래스만 import
-> 소스 시작 부분에 클래스의 경로명 import
-> import 패키지.클래스
-> 소스에는 클래스 명만 명시하면 됨

import java.util.Scanner;
public class ImportExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }
}

패키지 전체를 import
-> 소스 시작 부분에 패키지의 경로명.* import
-> import 패키지.*
-> 소스에는 클래스 명만 명시하면 됨
-> import java.util.*;
-> java.util 패키지 내의 모든 클래스만을 지정, 하위 패키지의 클래스는 포함하지 않음

import java.util.*;
public class ImportExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }
}
```

### 패키지 만들기
```java
클래스 파일(.class)이 저장되는 위치
-> 클래스나 인터페이스가 컴파일 되면 클래스 파일(.class) 생성
-> 클래스 파일은 패키지로 선언된 디렉터리에 저장

패키지 선언
-> 소스 파일의 맨 앞에 컴파일 후 저장될 패키지 지정
-> package 패키지명;

package UI; // Tools 클래스를 컴파일하여 UI 패키지(UI 디렉터리)에 저장할 것을 지시
public class Tools {
    ......
}
↑ Tools 클래스의 경로명 UI.Tools

package Graphic; // Line 클래스를 Graphic 패키지에 저장

import UI.Tools;
public class Line extend Shape {
    public void draw() {
        Tools t = new Tools();
    }
}

디폴트 패키지
package 선언문이 없는 자바 소스 파일
-> 컴파일러는 클래스나 인터페이스를 디폴트 패키지에 소속시킴
-> 디폴트 패키지 -> 현재 디렉터리
```

### package의 운영 방법
```java
패키지 이름은 도메인 기반으로 시작
-> ex) com.회사이름.프로젝트명.기능명

기능/역할별로 하위 패키지를 구분: utils, controller, service 등
디렉터리 구조와 package 선언을 정확히 일치해야 함
import는 필요한 만큼만, * 전체 import는 피하는 게 좋음
```


## 4월 18일(보강)

### 클래스 상속과 객체
```java
상속 선언: extends 키워드 사용
부모 클래스를 물려받아 자식 클래스를 확장한다는 의미

부모 클래스 -> 슈퍼 클래스(super class)
자식 클래스 -> 서브 클래스(sub class)

class Point {
    int x, y;
    ....
}

class ColorPoint extends Point { // Point를 상속받는 ColorPoint 클래스 선언
    ....
}

ColorPoint는 Point를 물려 받으므로, Point에 선언된 필드와 메소드 선언 필요 없음
```

### 자바 상속의 특징
```java
클래스 다중 상속(multiple inheritance) 불허
-> 하나의 클래스가 둘 이상의 부모 클래스를 동시에 상속받는 것

C++는 다중 상속 가능

C++는 다중 상속으로 멤버가 중복 생성되는 문제 있음 (다이아몬드 상속)
-> 부모 클래스 간에 계층적 관계가 있을 경우, 중복된 멤버 생성 가능
-> 모호성(Ambiguity) 문제: 두 부모 클래스에 동일한 이름의 멤버(변수나 함수)가 존재할 경우, 어떤 부모의 멤버를 호출해야 할지 모호해짐

자바는 인터페이스(interface)의 다중 상속 허용
-> 다중 상속과 유사한 기능 제공

모든 자바 클래스는 묵시적으로 Object 클래스 상속 받음
-> java.lang.Object / 모든 클래스의 슈퍼 클래스
```

### 슈퍼 클래스의 멤버에 대한 서브 클래스의 접근
```java
슈퍼 클래스의 private 멤버: 서브 클래스에서 접근 x

슈퍼 클래스의 디폴트 멤버: 서브 클래스가 동일한 패키지에 있을 때, 접근 가능

슈퍼 클래스의 public 멤버: 서브 클래스는 항상 접근 가능

슈퍼 클래스의 protected 멤버: 같은 패키지 내의 모든 클래스 접근 허용 / 패키지 여부와 상관없이 서브 클래스는 접근 가능
```

### 서브 클래스와 슈퍼 클래스의 생성자 선택
```java
슈퍼 클래스와 서브 클래스: 각각 여러 개의 생성자 작성 가능

서브 클래스의 객체가 생성될 때: 슈퍼 클래스 생성자 1개와 서브 클래스 생성자 1개가 실행

서브 클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식
1. 개발자의 명시적 선택
-> 서브 클래스 개발자가 슈퍼 클래스의 생성자 명시적 선택
-> super() 키워드를 이용하여 선택

2. 컴파일러가 기본 생성자 선택
-> 서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
-> 컴파일러가 자동으로 슈퍼 클래스의 기본 생성자 선택
```

### 업캐스팅(upcasting)
```java
하위 클래스의 레퍼런스는 상위 클래스를 가리킬 수 없지만, 상위 클래스의 레퍼런스는 하위 클래스를 가리킬 수 있다는 설명

ex)
생물이 들어가는 박스에 사람이나 코끼리를 넣어도 무방
사람이나 코끼리 모두 생물을 상속받았기 때문

서브 클래스의 레퍼런스를 슈퍼 클래스 레퍼런스에 대입
슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 되는 현상

class Person {
    String name;
    String id;
    public Person(String name) {
        this.name = name;
    }
}
class Student extends Person {
    String grade;
    String department;
    public Student(String name) {
        super(name);
    }
}

public class UpcastingEx {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("이재문");
        p = s; // 업캐스팅 발생
        System.out.println(p.name); // 오류 없음

        p.grade = "A"; // 컴파일 오류
        P.department = "Com"; // 컴파일 오류
    }
}
p 레퍼런스는 Person 타입이기 때문에 Person의 멤버에만 접근이 가능.
p.grade 와 p.department 는 Person 타입으로 Student의 멤버에 접근하려고 해서 오류
모든 멤버에 접근하려면 s 레퍼런스를 사용해야 함
```

### 그렇다면 왜 p = s로 업케스팅을 한 걸까?
```java
업케스팅의 제한 사항을 설명하기 위한 코드
실제로는 이런 식으로 사용하지 않음(UpcastingEx 참조)

실제로는 여러 자식 클래스를 하나의 부모 타입으로 다루기 위해 사용
Person[] people = new Person[3];
people[0] = new Student("홍길동");
people[1] = new Student("김영희");
people[2] = new Student("이순신");

이렇게 하면 공통된 타입(Person) 으로 여러 자식 클래스를 한 배열에 담을 수 있음
대신 접근은 Person 수준에서만 가능
```

### 다운캐스팅(downcasting)
```java
슈퍼 클래스 레퍼런스를 서브 클래스 레퍼런스에 대입
업캐스팅 된 것을 다시 원래대로 되돌리는 것
반드시 명시적 타입 변환 지정

public class DowncastingEx {
    public static void main(String args[]) {
        Person p = new Student("이재문"); // 업캐스팅
        Student s;

        s = (Student)p; // 다운캐스팅

        System.out.println(s.name); // 오류 없음
        s.grade = "A";
    }
}
```

### instanceof 연산자 사용
```java
레퍼런스가 가리키는 객체의 타입 식별: 연산의 결과는 true/false의 불린 값으로 변환

Person p = new Professor();

if(p instanceof Person) // true
if(p instanceof Student) // false
if(p instanceof Researcher) // true
if(p instanceof Professor) // true

if("java" instanceof String) // true
```

### 메소드 오버라이딩(Method Overriding)
```java
서브 클래스에서 슈퍼 클래스의 메소드 중복 작성
슈퍼 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 보장됨

오버라이딩 조건
-> 슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성

class A {
    void f() {
        System.out.println("A의 f() 호출");
    }
}
class B extends A {
    void f() { // 클래스 A의 f()를 오버라이딩
        System.out.println("B의 f() 호출");
    }
}
```

### 오버라이딩의 목적, 다형성 실현
```java
오버라이딩으로 다형성 실현
하나의 인터페이스(같은 이름)에 서로 다른 구현
슈퍼 클래스의 메소드를 서브 클래스에서 각각 목적에 맞게 다르게 구현
사례: Shape의 draw() 메소드를 Line, Rect, Circle에서 목적에 맞게 오버라이딩
```



## 4월 17일(7주차)

### 생성자의 종류
```java
* 기본 생성자(default constructor): 매개 변수 x, 아무 작업 없이 단순 리턴

class Circle {
    public Circle() { } // 기본 생성자
}

* 기본 생성자가 자동 생성되는 경우
- 클래스에 생성자가 하나도 선언되어 있지 않은 경우
- 컴파일러에 의해 기본 생성자 자동 생성

public class Circle {
    int radius;
    void set(int r) { radius = r; }
    double getArea() { return 3.14*radius*radius; }

    // 컴파일러에 의해 public Circle() { } 자동 삽입

    public static void main(String[] args) {
        Circle pizza = new Circle(); // 기본 생성자 호출
        pizza.set(5);
        System.out.println(pizza.getArea());
    }
}

* 기본 생성자가 자동 생성되지 않는 경우
- 클래스에 생성자가 선언되어 있는 경우
- 컴파일러는 기본 생성자를 자동 생성 x

public class Circle {
    int radius;
    void set(int r) { radius = r; }
    double getArea() { return 3.14*radius*radius; }

    // 컴파일러가 기본 생성자를 자동 생성하지 않음

    public Circle(int r) {
        radius = r;
    }

    public static void main(String[] args) {
        Circle pizza = new Circle(10);
        System.out.println(pizza.getArea());

        Circle donut = new Circle();  // 오류 메시지: The constructor Circle() is undefined
        System.out.println(donut.getArea());
    }
}
```

### this 레퍼런스
    객체 자신에 대한 레퍼런스
    컴파일러에 의해 자동 관리, 개발자는 사용만 하면 됨
    this.멤버 형태로 멤버 접근시에 사용

### this( )로 다른 생성자 호출
```java
같은 클래스의 다른 생성자 호출
생성자 내에서만 사용 가능
생성자 코드의 제일 앞에 있어야 함

public Book() {
    System.out.println("생성자 호출됨");
    this("", "");   // 컴파일 오류. 이 문장이 생성자의 첫 번째 문장이 아니기 때문
}
```

### 객체 배열
```java
객체에 대한 레퍼런스 배열
자바의 객체 배열 만들기 3단계

1. 배열 레퍼런스 변수 선언
Circle [] c;

2. 레퍼런스 배열 생성
c = new Circle[5];

3. 배열의 각 원소 객체 생성
for(int i = 0; i < c.length; i++) {
    c[i] = new Circle(i);
}
```

### 메소드
```java
메소드는 C/C++의 함수와 동일
자바의 모든 메소드는 반드시 클래스 안에 있어야 함(캡슐화 원칙)
메소드 형식

// 차례대로 접근 지정자, 리턴 타입, 메소드 이름, 메소드 인자들
public int getSum(int i, int j) {   
    int sum;
    sum = i + j;    // 메소드 코드
    return sum;
}

접근 지정자: 다른 클래스에서 메소드를 접근할 수 있는지 여부 선언
public, private, protected, 디폴트(접근 지정자 생략)
리턴 타입: 메소드가 리턴하는 값의 데이터 타입
```

### 인자 전달
```java
매개 변수가 byte, int, double 등 기본 타입으로 선언되었을 때
→ 호출자가 건네는 값이 매개 변수에 복사되어 전달. 실 인자 값은 변경 x

public class CallByValue {
    public static void main(String args[]) {
        int n = 10;
        increase(n);
        System.out.println(n); // 10
    }
    ↓ increase 호출
    static void increase(int m) {
        m = m + 1;
    }
}
```

### 인자 전달 - 객체가 전달되는 경우
```java
객체의 레퍼런스만 전달: 매개 변수가 실 인자 객체 공유

public class ReferencePassing {
    public static void main(String args[]) {
        Circle pizza = new Circle(10);    // radius = 10
        increase(pizza);

        System.out.println(pizza.radius); // radius = 11
    }
    ↓ increase 호출
    static void increase(Circle m) {
        m.radius++;
    }
}
```

### 인자 전달 - 배열이 전달되는 경우
```java
배열 레퍼런스만 매개 변수에 전달: 배열 통째로 전달 x
객체가 전달되는 경우와 동일: 매개 변수가 실인자의 배열 공유

public class ArrayPassing{
    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5};

        increase(a);

        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " "); // 2 3 4 5 6
        }
    }
    ↓ increase 호출
    static void increase(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i]++;
        }
    }
}
```

### 메소드 오버로딩(Overloading)
```java
한 클래스 내에서 두 개 이상의 이름이 같은 메소드 작성
메소드 이름이 동일해야 함
매개 변수의 개수 혹은 타입이 달라야 함
리턴 타입은 오버로딩과 관련 x

메소드 오버로딩 성공 사례

public class MethodSample {
    public int getSum(int i, int j) {
        return i + j;
    }
    public int getSum(int i, int j, int k) {
        return i + j + k;
    }
    public double getSum(double i, double j) {
        return i + j;
    }
    
    public static void main(String args[]) {
        MethodSample a = new MethodSample();
        int i = a.getSum(1, 2);
        int j = a.getSum(1, 2, 3);
        double k = a.getSum(1.1, 2.2);
    }
}

메소드 오버로딩 실패 사례

class MethodOverloadingFail {
    public int getSum(int i, int j) {
        return i + j;
    }
    public double getSum(int i, int j) {
        return (double)(i + j);
    }
    // 매개 변수의 개수와 타입이 같기 때문에 오버로딩 실패
}
```

### 객체 치환 시 주의할 점
```java
객체 치환은 객체 복사가 아니며, 레퍼런스의 복사임.

public class Samp {
    int id;
    public Samp(int x) {this.id = x;}
    public void set(int x) {this.id = x;}
    public int get() {return this.id;}

    public static void main(String args[]) {
        Samp ob1 = new Samp(3);
        Samp ob2 = new Samp(4);
        Samp s;

        s = ob2;
        ob1 = ob2; // 객체의 치환
        System.out.println("ob1.id="+ob1.get()); // 4
        System.out.println("ob2.id="+ob2.get()); // 4
    }
}
```

### 객체의 소멸
    * new로 할당 받은 객체와 메모리를 JVM으로 되돌려 주는 행위
    * 자바는 객체 소멸 연산자 x
    * 객체 소멸은 JVM의 고유한 역할

    * C/C++에서는 할당 받은 객체를 개발자가 프로그램 내에서 삭제해야 함
    * C/C++의 프로그램 작성을 어렵게 만드는 요인
    * 자바에서는 사용하지 않는 객체나 배열을 돌려주는 코딩 책임으로부터 개발자 해방

    ※ 단, 개발자의 선택 여지가 줄어드는 단점은 있음

### 가비지
```java
가리키는 레퍼런스가 하나도 없는 객체
더 이상 접근할 수 없어 사용할 수 없게 된 메모리
가비지 컬렉션: 자바 가상 기계의 가비지 컬렉터가 자동으로 가비지 수집, 반환

Person a, b;
a = new Person("이몽룡");
b = new Person("성춘향");

b = a; // b가 가리키던 객체는 가비지가 됨
```

### 가비지 컬렉션
```java
JVM이 가비지 자동 회수
가용 메모리 공간이 일정 이하로 부족해질 때
가비지를 수거하여 가용 메모리 공간으로 확보
가비지 컬렉터에 의해 자동 수행

강제 가비지 컬렉션 강제 수행: System 또는 Runtime 객체의 gc() 메소드 호출
System.gc(); // 가비지 컬렉션 작동 요청

이 코드는 JVM에 강력한 가비지 컬렉션 요청
그러나 JVM이 가비지 컬렉션 시점을 전적으로 판단
```

### 자바의 패키지 개념
    * 패키지
    - 상호 관련 있는 클래스 파일(컴파일된 .class)을 저장하여 관리하는 디렉터리
    - 자바 응용프로그램은 하나 이상의 패키지로 구성

### 접근 지정자
```java
자바의 접근 지정자 4가지: private, protected, public, 디폴트(접근 지정자 생략)
접근 지정자의 목적
클래스나 일부 멤버를 공개하여 다른 클래스의 접근 허용
객체 지향 언어의 캡슐화 정책은 멤버를 보호하는 것
→ 접근 지정은 캡슐화에 묶인 보호를 일부 해제할 목적으로 사용

접근 지정자에 따른 클래스나 멤버의 공개 범위
private (외부로부터 완벽차단)
디폴트 (동일 패키지에 허용)
protected (동일 패키지와 자식 클래스에 허용)
public (모든 클래스에 허용)
```

### 클래스 접근 지정
```java
다른 클래스에서 사용하도록 허용할 지 지정
public 클래스: 다른 모든 클래스에게 접근 허용
디폴트 클래스(접근 지정자 생략): 같은 패키지의 클래스에만 접근 허용

public class World { // public 클래스
    ...
}
class Local { // 디폴트 클래스
    ...
}
```

### 멤버 접근 지정
```java
public 멤버: 패키지에 관계 없이 모든 클래스에게 접근 허용
private 멤버: 동일 클래스 내에만 접근 허용. 상속 받은 서브 클래스에서 접근 불가.
protected 멤버:
같은 패키지 내의 다른 모든 클래스에게 접근 허용
상속 받은 서브 클래스는 다른 패키지에 있어도 접근 가능
디폴트(default) 멤버: 같은 패키지 내의 다른 클래스에게 접근 허용
```

### static 멤버 선언
```java
class StaticSample {
    int n; // non-static 필드
    void g() {...} // not-static 메소드
    static int m;  // static 필드
    static void f() {...} // static 메소드
}
객체 생성과 non-static 멤버의 생성
→ non-static 멤버는 객체가 생성될 때, 객체마다 생긴다.

class A {
    int n;
    void g() {...}
}

A a1 = new A();
A a2 = new A();
A a3 = new A();

static 멤버는 클래스당 하나만 생성
→ 객체들에 의해 공유됨

class StaticSample {
    int n;
    void g() {...}  
    static int m;
    static void f() {...} 
}

StaticSample b1 = new StaticSample();
static 멤버 m과 f()는 b1 객체가 생성되기 전에 존재

StaticSample b2 = new StaticSample();
StaticSample b3 = new StaticSample();
m과 f()는 b1, b2, b3 객체들에 의해 공유되는 static 멤버
```

### static 멤버 사용
```java
클래스 이름으로 접근 가능
StaticSample.m = 3; // 클래스 이름으로 static 필드 접근
StaticSample.f(); // 클래스 이름으로 static 메소드 호출

객체의 멤버로 접근 가능
StaticSample b1 = new StaticSample();
b1.m = 3; // 객체 이름으로 static 필드 접근
b1.f(); // 객체 이름으로 static 메소드 호출

non-static 멤버는 클래스 이름으로 접근 안 됨
StaticSample.n = 5; // n은 non-static이므로 컴파일 오류
StaticSample.g(); // g()은 non-static이므로 컴파일 오류

non-static → 모든 객체에 멤버 생성
static → 멤버 공유
```

### static의 활용
```java
전역 변수와 전역 함수를 만들 때 활용
공유 멤버를 만들 때: static으로 선언한 멤버는 클래스의 객체들 사이에 공유
```

### static 메소드의 제약 조건 1
```java
static 메소드는 오직 static 멤버만 접근 가능
객체가 생성되지 않은 상황에서도 static 메소드는 실행될 수 있기 때문에, non-static 멤버 활용 불가
non-static 메소드는 static 멤버 사용 가능

class StaticMethod {
    int n;
    void f1(int x) {n = x;} // 정상
    void f2(int x) {m = x;} // 정상
    static int m;
    static void s1(int x) {n = x;} // 컴파일 오류. static 메소드는 non-static 필드 n 사용 불가
    static void s2(int x) {f1(3);} // 컴파일 오류. static 메소드는 non-static 메소드 f1() 사용 불가
    static void s3(int x) {m = x;} // 정상. static 메소드는 static 필드 m 사용 가능 
    static void s4(int x) {s3(3);} // 정상. static 메소드는 static 메소드 s3() 호출 가능
}
```

### static 메소드의 제약 조건 2
```java
static 메소드는 this 사용불가
static 메소드는 객체 없이도 사용 가능하므로, this 레퍼런스 사용할 수 없음

static void f() { this.n = x; } // 오류. static 메소드에서는 this 사용 불가능
static void g() { this m = x; } // 오류. static 메소드에서는 this 사용 불가능
```

### final 클래스
```java
final 클래스 - 더 이상 클래스 상속 불가능

final class FinalClass {
    .....
}

class SubClass extends FinalClass { // 컴파일 오류 발생
    .....
}
```

### final 메소드
```java
final 메소드 - 더 이상 메소드 오버라이딩 불가능
public class SuperClass {
    protected final int finalMethod() { ... }
}
class subClass extends SuperClass { // SubClass가 SuperClass를 상속받음
    protected int finalMethod() { ... } // 컴파일 오류. finalMethod() 오버라이딩할 수 없음
}
```

### final 필드
```java
final 필드: 상수를 선언할 때 사용

class SharedClass {
    public static final double PI = 3.14;
}

상수 필드는 선언 시에 초기 값을 지정
상수 필드는 실행 중에 값 변경 x
```

## 4월 10일(6주차)

### 예외 처리(try-catch-finally)
```java
발생한 예외에 대해 개발자가 작성한 프로그램 내에서 대응하는 것

try {
    예외 발생 가능성 있는 실행문
}
catch(처리할 예외 타입 선언) { // ex) ArithmeticException e
    예외 처리문
}
finally {
    예외 발생 여부와 상관없이 무조건 실행되는 문장 // 생략 가능
}
```

### 객체
    자신만의 고유한 특성(state)과 행동(behavior)을 가지며 다른 객체들에게 행동을 요구하거나 정보를 주고받는 등 상호 작용하며 살아감.
    - ex) TV, 의자, 책, 집, 카메라, ...

### 자바의 객체 지향 특성 : 캡슐화
    * 캡슐화 
    - 객체를 캡슐로 싸서 내부를 볼 수 없게 하는 것
    - 객체의 가장 본질적인 특징
    - 외부의 접근으로부터 객체를 보호함

    * 자바의 캡슐화
    - 클래스(class): 객체 모양을 선언한 틀(캡슐화하는 틀)
    - 객체: 생성된 실체(instance): 클래스 내에 메소드와 필드 구현

### 자바의 객체 지향 특성 : 상속
    * 상속
    - 상위 객체의 속성을 하위 객체에 물려 줌.
    - 하위 객체가 상위 객체의 속동을 모두 가지는 관계

    * 현실세계의 상속 사례
    - 나무는 식물의 속성과 생물의 속성을 모두 가짐.
    - 사람은 생물의 속성은 가지지만 식물의 속성은 가지고 있지 않음.

### 자바의 상속
```java
* 자바의 상속
- 상위 클래스의 멤버를 하위 클래스가 물려받음
- 상위 클래스: 슈퍼 클래스
- 하위 클래스: 서브 클래스, 슈퍼 클래스 코드 재사용, 새로운 특성 추가 O

ex)
class Animal {
    String name;
    int age;
    void eat() {...}
    void speak() {...}
    void love() {...}
}
↑ 상속
class Human extends Animal {
    String hobby;
    String job;
    void work() {...}
    void cry() {...}
    void laugh() {...}
}
```

### 자바의 객체 지향 특성: 다형성
    * 다형성
    - 같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 구현되는 것
    * 다형성 사례
    - 메소드 오버로딩: 한 클래스 내에서 같은 이름이지만 다르게 작동하는 여러 메소드
    - 메소드 오버라이딩: 슈퍼 클래스의 메소드를 동일한 이름으로 서브 클래스마다 다르게 구현

### 절차 지향 프로그래밍 & 객체 지향 프로그래밍
    * 절차 지향 프로그래밍
    - 작업 순서를 표현하는 컴퓨터 명령 집합
    - 함수들의 집합으로 프로그램 작성

    * 객체 지향 프로그래밍
    - 컴퓨터가 수행하는 작업을 객체들 간의 상호 작용으로 표현
    - 클래스 혹은 객체들의 집합으로 프로그램 작성

### 클래스 & 객체
    * 클래스
    - 객체의 속성과(state)과 행위(behavior) 선언. 객체의 설계도 or 틀

    * 객체
    - 클래스의 틀로 찍어난 실체
    - 프로그램 실행 중에 생성되는 실체
    - 메모리 공간을 갖는 구체적인 실체
    - 인스턴스(instance)라고도 함.

### 자바 클래스 구성
```java
* 자바 클래스
- class 키워드로 선언
- 멤버: 클래스 구성 요소. 필드(멤버 변수) & 메소드(멤버 함수)
- 클래스에 대한 public 접근 지정: 다른 모든 클래스에서 클래스 사용 허락
- 멤버에 대한 public 접근 지정: 다른 모든 클래스에게 멤버 접근 허용

ex)
public class Circle {
    int radius;     // 필드(멤버 변수)
    String name;

    public double getArea() {   // 메소드(멤버 함수)
        return 3.14*radius*radius;
    }
}
```

### 객체 생성과 활용
```java
1. 레퍼런스 변수 선언
Circle pizza; // 레퍼런스 변수 pizza 선언
```
```java
2. new 연산자로 객체 생성
pizza = new Circle(); // Circle 객체 생성
```

```java
3. 선언과 동시에 객체 생성
Circle pizza = new Circle() // 레퍼런스 변수 pizza의 선언과 동시에 객체 생성
```

```java
4. 객체 멤버 접근
- 객체레퍼런스.멤버

ex)
pizza.radius = 10; // pizza 객체의 radius 값을 10으로 설정
pizza.name = "자바피자" // pizza 객체의 name에 "자바피자" 대입
double area = pizza.getArea(); // pizza 객체의 getArea() 메소드 호출
```

### 생성자
    객체가 생성될 때 초기화 목적으로 실행되는 메소드
    객체가 생성되는 순간에 자동 호출

### 생성자의 특징
```java
생성자 이름은 클래스 이름과 동일
생성자는 여러 개 작성 가능(생성자 중복)

ex)
public class Circle {
    public Circle() {...} // 매개 변수 없는 생성자
    public Circle(int r, String n) {...} // 2개의 매개 변수를 가진생성자
}
```

```java
생성자는 객체 생성 시 한번만 호출
자바에서 객체 생성은 반드시 new 연산자로 함
생성자의 목적은 객체 생성 시 초기화

ex)
Circle pizza = new Circle(10, "자바피자");  // 생성자 Circle(int r, String n) 호출
Circle donut = new Circle();                // 생성자 Circle() 호출
```
```java
생성자는 리턴 타입 지정 불가

ex)
public void Circle() {...} // error. void를 리턴 타입으로 사용할 수 없음.
```

## 4월 3일(5주차)

### for 문
```java
for(초기문; 조건식; 반복 후 작업) {
    ..작업문..
}
    
ex)
for(int i = 0; i < 10; i++) {   // 0에서 9까지 출력
    System.out.print(i);
}
```
    
```java
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
```

### while 문
```java
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
```

### do-while 문
```java
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
```

### 중첩 반복
```java
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
```

### continue / break
    반복문과 함께 사용되면서 반복의 흐름을 바꾸거나 반복에서 벗어나게 하는 중요한 기능을 함.

### continue
```java
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
```

### break
```java
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
```

### 배열
    인덱스(index)와 그에 대응하는 데이터들로 이루어진 연속적인 자료 구조
    같은 종류의 데이터들이 순차적으로 저장됨.

```java
1. 선언
레퍼런스 변수를 선언하는 것으로 배열 공간이 생성되지 않음.
레퍼런스라고 불리는 배열의 주소 값을 가지는 상태일 뿐임.
c언어의 포인터라고 생각하면 이해하기 쉬움.

int intArray[];     // 선언
선언 시 [] 안에 배열 크기를 지정하면 안됨.
int intArray[5];    // 오류
```

```java
2. 생성
- 배열 공간을 할당받는 과정
- new 연산자를 이용하여 배열을 생성하며 [] 안에 생성할 원소 개수 지정
intArray = new int[5]; // 5개의 정수 배열 할당
```

```java
3. 선언 및 생성
int intArray[] = new int[5] // 배열 선언과 동시에 배열 생성
```
```java
4. 초기화
선언문에서 { } 사이에 원소를 나열하여 초기화된 배열 만들 수 있음.
int intArray[] = {4, 3, 2, 1, 0}; // 크기는 자동으로 5가 됨.
배열의 크기는 { } 사이에 나열된 값의 개수로 정해짐.
```   

```java
5. 인덱스 / 원소 접근
인덱스는 0 이상의 양의 정수만 가능함.
마지막 원소의 인덱스는 (배열 크기 - 1)

int intArray = new int[5] // 인덱스는 0~4까지 가능
intArray[0] = 5; // 원소 0에 5 저장
intArray[3] = 6; // 원소 3에 6 저장
int n = intArray[3]; // 원소 3의 값인 6을 n에 저장

※ 오류
int n = intArray[-2]; // 인덱스는 음수 사용 불가
int m = intArray[5]; // intArray의 마지막 인덱스는 4이므로 범위 초과

※ 오류2
int intArray[]; // 레퍼런스만 선언
intArray[1] = 8; // 배열이 생성되어 있지 않아 불가능.
```

```java
6. 치환 / 배열 공유
자바는 배열 공간과 레퍼런스 변수가 분리되어 있기에 생성된 배열의 공유가 쉽게 이루어짐.
int intArray[] = new int[5]; // 선언과 생성
int myArray[] = intArray; // 레퍼런스 치환, 쉽게 말해 myArray도 intArray와 동일한 배열의 주소값을 가짐.
```

### 배열의 크기, length 필드
```java
자바는 배열을 객체로 다룸.
배열이 생성되면 배열 공간과 배열의 크기 값을 가진 length 필드가 배열 객체 내에 생성됨.
length 필드를 사용하면 배열의 크기를 쉽게 알아낼 수 있음.

int intArray[] = new int[5];
int size = intArray.length; // size = 5

for(int i = 0; i < intArray.length; i++) { // intArray 배열 크기만큼 루프
    System.out.print(intArray[i]);
}
```

### for-each 문
```java
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
```
### 2차원 배열
```java
1. 선언
int intArray[][]; || int[][] intArray;
```
```java
2. 생성
intArray = new int[2][5]; // 2행 5열(2x5)의 2차원 배열 생성
* 첫번째 []는 행의 개수이고 두번째 []는 열의 개수임.
```

```java
3. 선언 및 생성
int intArray[][] = new int[2][5];
```

```java
4. 초기화
배열을 선언할 때 원소를 초기화할 수 있음.
int intArray[][] = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} } // 3x3 배열 생성
```
```java
5. 구조
int i[][] = new int[2][5];
int size1 = i.length; // 2차원 배열의 행의 개수 = 2
int size2 = i[0].length; // 0번째 행의 열의 개수 = 5
int size3 = i[1].length; // 1번째 행의 열의 개수 = 5
```
### 메소드의 배열 리턴
    배열의 레퍼런스(주소)만 리턴됨.
    리턴하는 배열 타입과 리턴 받는 배열 타입이 일치해야 함.
    리턴 타입에 배열의 크기는 지정하지 않음.

```java
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
```

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
```java
java.util.Scanner
객체를 생성해서 사용함.
키보드에 연결된 System.in에게 키를 읽게 하고, 원하는 타입으로 변환하여 리턴함.
입력되는 키 값을 공백으로 구분되는 토큰 단위로 읽음.
공백 문자 : '\t', '\r', '\n', ' ', '\f' ...
```
---
