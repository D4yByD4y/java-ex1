package chapter_07;

import java.util.Vector;

class Ex72Point {
    private int x, y;
    public Ex72Point(int x, int y) {
        this.x = x; this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class Ex72PointVectorEx {
    public static void main(String[] args) {
        Vector<Ex72Point> v = new Vector<Ex72Point>();  // Ex72Point 객체를 요소로 다루는 벡터 생성

        // 3개의 Ex72Point 객체 삽입
        v.add(new Ex72Point(2, 3));
        v.add(new Ex72Point(-5, 20));
        v.add(new Ex72Point(30, -8));

        v.remove(1);    // 인덱스 1의 Ex72Point(-5, 20) 객체 삭제

        // 벡터에 있는 Ex72Point 객체 모두 검색하여 출력
        for (int i = 0; i < v.size(); i++) {
            Ex72Point p = v.get(i); // 벡터의 i번째 Ex72Point 객체 얻어내기
            System.out.println(p);
        }
    }
}
