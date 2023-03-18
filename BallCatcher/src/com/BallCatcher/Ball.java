package com.BallCatcher;

import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {

    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 3;

    Ball(int x, int y, int width, int height){
        //Because ball is a sub-class of the Rectangle super-class
        super(x,y,width,height);
        random = new Random();

        int randomYDirection = random.nextInt(2);

        if(randomYDirection == 0) {
            randomYDirection--;
        }
        setYDirection(randomYDirection*initialSpeed);
    }

    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }


    public void move(){
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,height,width);
    }


}
