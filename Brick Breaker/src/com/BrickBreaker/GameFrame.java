package com.BrickBreaker;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();
        this.add(panel);

        this.setTitle("Ball Catcher");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground((Color.BLACK));
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
