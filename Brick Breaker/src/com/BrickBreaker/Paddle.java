package com.BrickBreaker;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{

    int id;
    int yVelocity;
    int speed = 2;


    Paddle(int x, int y, int paddleWidth, int paddleHeight, int id){
        super(x,y,paddleWidth,paddleHeight);
        this.id=id;
    }

    public void keyPressed(KeyEvent e){
        switch (id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setY(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setY(speed);
                    move();
                }
                break;
        }

    }

    public void keyReleased(KeyEvent e){
        switch (id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setY(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
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
        x = x + yVelocity;
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
