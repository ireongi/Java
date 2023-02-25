// 프레임에 컴포넌트 추가하기(add) & 강제 종료 설정(setDefaultCLoseOperation(JFrame.EXIT_ON_CLOSE))
package GUI;

import javax.swing.*;

public class _3_EndFrame extends JFrame {
    _3_EndFrame(){
        setTitle("Hello Swing");

        JButton button = new JButton("Button");
        add(button); // 버튼을 프레임의 ContenentPane 에 부착
    //  getContentPane().add(button) //java4 이하

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 애플리케이션을 강제 종료하도록
        setSize(200, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new _3_EndFrame();
    }
}
