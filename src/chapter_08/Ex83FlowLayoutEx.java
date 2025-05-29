package chapter_08;
import javax.swing.*;
import java.awt.*;

public class Ex83FlowLayoutEx extends JFrame {
    public Ex83FlowLayoutEx() {
        setTitle("FlowLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        // 왼쪽 정렬로, 수평 간격을 30, 수직 간격을 40 픽셀로 배치하는 FlowLayout 생성
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));

        contentPane.add(new JButton("add"));
        contentPane.add(new JButton("sub"));
        contentPane.add(new JButton("mul"));
        contentPane.add(new JButton("div"));
        contentPane.add(new JButton("Calculate"));

        setSize(300, 200);  // 프레임 크기 300x200 설정
        setVisible(true);   // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new Ex83FlowLayoutEx();
    }
}
