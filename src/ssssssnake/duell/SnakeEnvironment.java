/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import environment.Environment;
import environment.Grid;
import image.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author user
 */
class SnakeEnvironment extends Environment {

    private Grid grid;
    private int score = 0;
    private Snake snake;
    private int delay=4;
    private int moveCounter = delay;

    public SnakeEnvironment() {
    }

    @Override
    public void initializeEnvironment() {
        this.setBackground(ResourceTools.loadImageFromResource("resources/cards.jpg"));
        this.grid = new Grid();
        this.grid.setColor(Color.white);
        this.grid.setColumns(44);
        this.grid.setRows(25);
        //this.grid.setCellHeight(20);
        //this.grid.setCellWidth(20);
        this.grid.setPosition(new Point(10, 70));
        this.snake = new Snake();
        this.snake.getBody().add(new Point(5, 5));
        this.snake.getBody().add(new Point(5, 4));
        this.snake.getBody().add(new Point(5, 3));
        this.snake.getBody().add(new Point(4, 3));
        this.snake.getBody().add(new Point(4, 2));
        this.snake.getBody().add(new Point(3, 2));
    }

    @Override
    public void timerTaskHandler() {
        System.out.println("Timer");
        if (snake != null){            
            if(moveCounter <= 0){
                snake.move();
                moveCounter = delay;
            } else{
                moveCounter--;                
            }           
            snake.move();
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.score += 800000;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.move();
        }else if (e.getKeyCode() == KeyEvent.VK_W){
        
           // if(e.getKeyCode() == KeyEvent.VK_A{
              //  snake.move();
            //}



        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (this.grid != null) {
            this.grid.paintComponent(graphics);

            Point cellLocation;
            graphics.setColor(Color.CYAN);
            if (snake != null) {
            for (int i = 0; i < snake.getBody().size(); i++) {
            cellLocation = grid.getCellPosition(snake.getBody().get(i));
            graphics.fillOval(cellLocation.x, cellLocation.y, grid.getCellWidth(), grid.getCellHeight());

                }

            }
        }


        graphics.setFont(new Font("Calibri", Font.BOLD, 50));
        graphics.drawString("Score: " + this.score, 50, 50);
        //grid.getCellPosition(score, score)
    }
}
