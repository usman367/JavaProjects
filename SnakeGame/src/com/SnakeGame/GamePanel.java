package com.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    static final int screenWidth = 600;
    static final int screenHeight = 600;
    static final Dimension Screensize = new Dimension(screenWidth, screenHeight);
    static final int unitSize = 20;//Change this to change size of game (Snake and Ball) (Was 25)
    static final int gameUnits = (screenWidth*screenHeight)/unitSize;
    static final int Delay = 75;//The higher this is the slower the game is (Was 75)
    final int[] x = new int [gameUnits];
    final int[] y = new int[gameUnits];
    int bodyParts = 6; //The length of snake at the start
    int applesEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R';//Moving to the Right at the start
    boolean running = false;//Changes to true when the game starts
    Timer timer;
    Random random;

    GamePanel(){
        random = new Random();
        this.setPreferredSize(Screensize);
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(Delay,this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){

        if(running){
            /*
            for (int i = 0; i<screenHeight/unitSize; i++){
                g.drawLine(i*unitSize, 0, i+unitSize, screenHeight);
                g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
            }

             */

            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, unitSize, unitSize);
            //Drawing the snake
            for(int i = 0; i<bodyParts; i++){
                if(i == 0) {
                    g.setColor(Color.GREEN);//Front of snake is Dark Green
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }else{
                    g.setColor(new Color(45, 100, 0));//Rest of snake if Light green
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
            }
            //Scorecard
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (screenWidth - metrics.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }

    public void newApple(){
        appleX = random.nextInt((int)(screenWidth/unitSize))*unitSize;
        appleY = random.nextInt((int)(screenHeight/unitSize))*unitSize;
    }

    public void move(){
        for (int i = bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        //Moving snake when keys pressed
        switch (direction){
            case 'U':
                y[0] = y[0] - unitSize;
                break;
            case 'D':
                y[0] = y[0] + unitSize;
                break;
            case 'L':
                x[0] = x[0] - unitSize;
                break;
            case 'R':
                x[0] = x[0] + unitSize;
                break;
        }
    }

    public void checkApple(){
        if((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollision(){
        //Checks if head collides with body
        for(int i = bodyParts; i>0; i--){
            if(x[0] == x[i] && y[0]== y[i]){
                running = false;
            }
        }
        //Checks if head touches left border
        if(x[0] < 0){
            running = false;
        }
        //Checks if head touches right border
        if(x[0] > screenWidth){
            running = false;
        }

        //Check if head touches top border
        if(y[0]< 0){
            running = false;
        }
        //Check if head touches bottom border
        if(y[0] > screenHeight){
            running = false;
        }

        if(!running){
            timer.stop();
        }
    }

    public void gameOver(Graphics g){
        //Score
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (screenWidth - metrics1.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());

        //GameOver text
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (screenWidth - metrics2.stringWidth("Game Over"))/2, screenHeight/2);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }
        }

    }
}
