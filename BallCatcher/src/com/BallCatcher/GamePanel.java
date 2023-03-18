package com.BallCatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{
    static final int width = 1000;
    static final int height = (int)(width * (0.5555));
    static final Dimension Screensize = new Dimension(width,height);
    static final int ballDiameter = 20;
    static final int paddleWidth = 140;
    static final int paddleHeight = 20;
    static final int getPaddleHeight = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Ball ball;
    Ball ball2;
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
        ball = new Ball(random.nextInt(width),0,ballDiameter,ballDiameter);
        ball2 = new Ball(random.nextInt(width),0,ballDiameter,ballDiameter);
    }

    public void newPaddles(){
        paddle1 = new Paddle(width/2, height-20, paddleWidth, paddleHeight, 1);

    }

    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw (Graphics g){
        paddle1.draw(g);
        ball.draw(g);
        ball2.draw(g);
        score.draw(g);
    }

    public void move(){
        //We add these to make their movement more smooth
        //We don't need them
        paddle1.move();
        ball.move();
        ball2.move();
    }

    public  void checkCollision(){
        //Check if balls gone over the screen

        if(ball.y < 0){
            ball.setYDirection(-ball.yVelocity);
        }

        if ((ball.y >= height-ballDiameter)){
            //ball.setYDirection(-ball.yVelocity);
            newBall();

        }

        if(ball2.y < 0){
            ball2.setYDirection(-ball2.yVelocity);
        }

        if ((ball2.y >= height-ballDiameter)){
            //ball.setYDirection(-ball.yVelocity);
            newBall();

        }

        //Check if balls collides with the paddles
        if(ball.intersects(paddle1)){
            score.player1++;
            newBall();
            System.out.println("Player 1: " + score.player1);
        }

        if(ball2.intersects(paddle1)){
            score.player1++;
            newBall();
            System.out.println("Player 1: " + score.player1);
        }

        //Stops paddles at window edges
        if(paddle1.x<=0){
            paddle1.x=0;
        }
        if(paddle1.x>=(width-paddleWidth)){
            paddle1.x = width-paddleWidth;
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
        }
        public  void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
        }
    }
}
