package com.Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Delayed;

public class GamePanel extends JPanel implements Runnable{
    static final int width = 1000;
    static final int height = (int)(width * (0.5555));
    static final Dimension Screensize = new Dimension(width,height);
    static final int ballDiameter = 20;
    static final int paddleWidth = 25;
    static final int paddleHeight = 100;
    static final int getPaddleHeight = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddles paddle1;
    Paddles paddle2;
    Ball ball;
    Score score;

    GamePanel(){
        newPaddles();
        newBall();
        score = new Score(width,height);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(Screensize);

        gameThread = new Thread(this);
        gameThread.start();
    }


    public void newBall(){
        random = new Random();
        ball = new Ball((width/2)-(ballDiameter/2),random.nextInt(height-ballDiameter),ballDiameter,ballDiameter);
    }

    public void newPaddles(){
        paddle1 = new Paddles(0, (height/2)-(paddleHeight/2), paddleWidth, paddleHeight, 1);
        paddle2 = new Paddles(width-paddleWidth, (height/2)-(paddleHeight/2), paddleWidth, paddleHeight, 2);
    }

    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw (Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move(){
        //We add these to make their movement more smooth
        //We don't need them
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public  void checkCollision(){
        //bounce all off top & and bottom edges
        if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }
        if ((ball.y >= height-ballDiameter)){
            ball.setYDirection(-ball.yVelocity);
        }

        //Bounces ball of paddles
        if(ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//Optional to make the ball faster
            if(ball.yVelocity>0){
                ball.yVelocity++;//Optional for difficulty
            }else{
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//Optional to make the ball faster
            if(ball.yVelocity>0){
                ball.yVelocity++;//Optional for difficulty
            }else{
                ball.yVelocity--;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        //Stops paddles at window edges
        if(paddle1.y<=0){
            paddle1.y=0;
        }
        if(paddle1.y>=(height-paddleHeight)){
            paddle1.y = height-paddleHeight;
        }
        if(paddle2.y<=0){
            paddle2.y=0;
        }
        if(paddle2.y>=(height-paddleHeight)){
            paddle2.y = height-paddleHeight;
        }

        //give a player 1 point and create new paddles and ball
        if(ball.x <= 0){
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2: " + score.player2);
        }
        if(ball.x >= width-ballDiameter){
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: " + score.player1);
        }

    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >=1){
                move();
                checkCollision();
                repaint();
                delta--;

            }
        }
    }


    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public  void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
