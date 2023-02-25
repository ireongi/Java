// 패널 : 다른 컴포넌트를 배치할 수 있는 가상의 투명한 공간 제공
//       ex) 보드에 메모지 붙인 후 보드를 칠판에 부착
// 보통 컴포넌트(버튼, 레이블 등)를 그룹으로 묶어 패널에 부착 -> 패널을 프레임에 부착
package GUI;

import javax.swing.*;

public class _3_JPanel extends JFrame {
    _3_JPanel(){
        setTitle("Hello Swing");

        JPanel panel = new JPanel(); // 패널 생성
        JLabel lable = new JLabel("Hello Swing"); // 레이블 생성
        JButton button = new JButton("Button"); // 버튼 생성

        panel.add(lable); // 패널에 레이블과 버튼 부탁
        panel.add(button);
        add(panel); // 프레임에 패널 부착

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        pack(); // 내용에 맞게 창 크기 조절
        setVisible(true);

    }

    public static void main(String[] args) {
        new _3_JPanel();
    }
}
