package com.Pong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddles extends Rectangle{
    int id;
    int yVelocity;
    int speed = 10;


    Paddles(int x, int y, int paddleWidth, int paddleHeight, int id){
        super(x,y,paddleWidth,paddleHeight);
        this.id=id;
    }

    public void keyPressed(KeyEvent e){
        switch (id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setY(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setY(speed);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setY(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setY(speed);
                    move();
                }
                break;
        }

    }

    public void keyReleased(KeyEvent e){
        switch (id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setY(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setY(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setY(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setY(0);
                    move();
                }
                break;
        }
    }



    public void setY(int yDirection){
        yVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
    }

    public  void draw(Graphics g){
        if(id == 1){
            g.setColor(Color.blue);
        }else{
            g.setColor(Color.RED);
        }
        g.fillRect(x,y,width,height);
    }
}


