package GUI;

import javax.swing.*;
import java.awt.*;

public class _5_BorderLayout extends JFrame {
    _5_BorderLayout(){
        setTitle("Border Layout");
        setLayout(new BorderLayout());

        add("East", new JButton("East"));
        add("West", new JButton("West"));
        add("South", new JButton("South"));
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("Center"), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new _5_BorderLayout();
    }
}
