package chapter_09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex97FlyingTestEx extends JFrame {
    private JLabel la = new JLabel("HELLO");

    public Ex97FlyingTestEx() {
        super("상,하,좌,우 키를 이용하여 텍스트 움직이기");

        Container c = getContentPane();
        c.setLayout(null);  // 컨텐트팬의 배치관리자 삭제
        c.addKeyListener(new Ex97MyKeyListener());  // 컨텐트팬에 키 리스너 달기    
        la.setLocation(50, 50); // 레이블의 초기 위치는 (50, 50)
        la.setSize(100, 20);
        c.add(la);
        setSize(200, 200);
        setVisible(true);

        c.setFocusable(true);   // 컨텐트팬이 포커스를 받을 수 있도록 설정
        c.requestFocus();   // 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정
    }

    class Ex97MyKeyListener extends KeyAdapter {    // Key 리스너 구현
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();   // 입력된 키의 키코드 알아내기. 상,하,좌,우 키는 유니코드 키가 아니기 때문에 getKeyCode() 사용
            switch (keyCode) {  // 키 코드에 따라 상,하,좌,우 키 판별, 레이블의 위치 이동
                case KeyEvent.VK_UP:    // UP 키
                    la.setLocation(la.getX(), la.getY() - 10); break;
                case KeyEvent.VK_DOWN:    // DOWN 키
                    la.setLocation(la.getX(), la.getY() + 10); break;
                case KeyEvent.VK_LEFT:    // LEFT 키
                    la.setLocation(la.getX() - 10, la.getY()); break;
                case KeyEvent.VK_RIGHT:    // RIGHT 키
                    la.setLocation(la.getX() + 10, la.getY()); break;
            }
        }
    }

    public static void main(String[] args) {
        new Ex97FlyingTestEx();
    }
}
