package chapter_09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex92InnerClassListener extends JFrame {
    public Ex92InnerClassListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new Ex92MyActionListener());  // Action 이벤트 리스너 달기
        c.add(btn);

        setSize(250, 120);
        setVisible(true);
    }

    // 내부 클래스로 Action 리스너 작성
    private class Ex92MyActionListener implements ActionListener {
    // 이 클래스는 내부 클래스이므로 자신을 둘러싼 외부 클래스인 Ex92InnerClassListener나 상속받은 JFrame의 모든 멤버에 접근할 수 있음
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource(); // 이벤트 소스 버튼 알아내기
            if(b.getText().equals("Action")) {  // 버튼의 문자열이 "Action"인지 비교
                b.setText("액션");  // 버튼의 문자열을 "액션"으로 변경
            }
            else {
                b.setText("Action");    // 버튼의 문자열을 "Action"으로 변경
            }
            // InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
            Ex92InnerClassListener.this.setTitle(b.getText());  // 프레임의 타이틀에 버튼 문자열을 출력
            // setTitle(b.getText()); 로도 가능
        }
    }

    public static void main(String[] args) {
        new Ex92InnerClassListener();
    }
}
