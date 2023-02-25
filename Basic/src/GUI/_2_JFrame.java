package GUI;

// Frame : 애플리케이션을 위한 창 생성 & 타이틀과 메뉴 지원 & 보더와 시스템 상자(최소.최대화.닫기 버튼) 제공
//         java.awt.Frame 상속받은 자식클래스임(WindowConstants, Accessible, RootPaneContainer 인터페이스 구현)

import javax.swing.*;

public class _2_JFrame {

    class Frame1 extends JFrame {
        Frame1(){
            setTitle("Hello Swing");
            setSize(200, 100);
            setVisible(true);
        }
    }
    public class Frame1Demo{
        public static void main(String[] args) {
            new _2_JFrame();
        }
    }


}
