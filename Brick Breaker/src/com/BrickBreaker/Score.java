package com.BrickBreaker;

import java.awt.*;
import java.sql.PseudoColumnUsage;

public class Score extends Rectangle{

    static int width;
    static int height;
    int player1;

    Score(int width, int height){
        Score.width = width;
        Score.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));

        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10),(width/2)-30, 50 );
    }
}
