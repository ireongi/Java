package GUI;

import javax.swing.*;

public class _1_HelloSwing {
    public static void main(String[] args) {
        JFrame helloSwing = new JFrame(); // 프레임 생성

        helloSwing.setTitle("Hello Swing"); // 프레임 제목 설정
        helloSwing.setSize(200, 100); // 프레임 크기 설정

        helloSwing.setVisible(true); // 화면에 표시, setVisible 호출하기 전에 필요한 컴포넌트 전부 프레임에 부착해야함

        // 스윙 -> main() 종료 후  -> 이벤트 디스패치 스레드를 실행
        // so main 메서드 종료 후에도 생성한 프레임을 사용할 수 있음
        // 스윙 어플리케이션을 종료하려면? 이벤트 디스패치 스레드도 종료하도록 처리해야함
    }
}
