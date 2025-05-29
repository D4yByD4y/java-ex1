package chapter_08;
import javax.swing.*;

public class Ex81MyFrame extends JFrame {
    public Ex81MyFrame() {
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300, 300);  // 프레임 크기 300x300
        setVisible(true);   // 프레임 출력
    }

    public static void main(String[] args) {
        // Ex81MyFrame frame = new Ex81MyFrame();
        new Ex81MyFrame();  // 실무에서는 이렇게 사용
    }
}
