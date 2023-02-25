package GUI;

import javax.swing.*;
import java.awt.*;

public class _1_FlowLayout extends JFrame{

        _1_FlowLayout(){
            setTitle("Flow Layout");

            JPanel j = new JPanel(new FlowLayout()); // new FlowLayout() 생략 가능 - JPanel의 기본 배치 방식
            j.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            JButton button1 = new JButton("Button1");
            JButton button2 = new JButton("Button2");
            JButton button3 = new JButton("Button3");
            JButton button4 = new JButton("Button4");

            j.add(button1);
            j.add(button2);
            j.add(button3);
            j.add(button4);
            add(j);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 110);
            setVisible(true);
        }

        public static void main(String[] args) {
            new _1_FlowLayout();
        }
    }

