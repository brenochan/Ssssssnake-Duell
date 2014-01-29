/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import audio.AudioPlayer;
import environment.Environment;
import environment.GraphicsPalette;
import environment.Grid;
import image.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author user
 */
class SnakeEnvironment extends Environment {

    private Grid grid;
    private int score = 0;
    private Snake snake;
    private ArrayList<Point> apples;
    private int delay = 0;
    private int moveCounter = delay;
    private Image burger;
    private ArrayList<Point> hamburgers;
    private Image Fries;
    private ArrayList<Point> frenchfries;
    private Image banana;
    private Image coke;
    private ArrayList<Point> cocacola;
    private Image hotdog;
    private Image donut;
    private Image fish;
    private Image grapes;
    private Image orange;
    private Image pizza;
    private Image watermelon;
    private ArrayList<Point> watermelons;
    private Image strawberries;
    private Image pineapple;
    private int burgerint = 0;
    private int i;
    private Image itunes;
    private ArrayList<Point> itunes1;

    

    public SnakeEnvironment() {
    }

    @Override
    public void initializeEnvironment() {
        this.setBackground(new Color(124, 205, 124));
        this.grid = new Grid();
        this.grid.setColor(new Color(124, 205, 124));
        this.grid.setColumns(44);
        this.grid.setRows(25);
        //this.grid.setCellHeight(20);
        //this.grid.setCellWidth(20);
        this.grid.setPosition(new Point(10, 70));
        //apple
        this.apples = new ArrayList<Point>();
        this.apples.add(getRandomGridLocation());
        //snake
        this.snake = new Snake();
        this.snake.getBody().add(new Point(5, 5));
        this.snake.getBody().add(new Point(5, 4));
        this.snake.getBody().add(new Point(5, 3));
        this.snake.getBody().add(new Point(4, 3));
        this.snake.getBody().add(new Point(4, 2));
        this.snake.getBody().add(new Point(3, 2));
        //burger
        this.hamburgers = new ArrayList<Point>();
        this.hamburgers.add(getRandomGridLocation());
        this.burger = ResourceTools.loadImageFromResource("resources/burger.png");
        //fries
        this.Fries = ResourceTools.loadImageFromResource("resources/fries.png");
        this.frenchfries = new ArrayList<Point>();
        this.frenchfries.add(getRandomGridLocation());
        this.fish = ResourceTools.loadImageFromResource("resources/fish.png");
        this.watermelon = ResourceTools.loadImageFromResource("resources/watermelon.png");
        this.watermelons = new ArrayList<Point>();
        this.watermelons.add(getRandomGridLocation());
        this.cocacola = new ArrayList<Point>();
        this.cocacola.add(getRandomGridLocation());
                this.coke = ResourceTools.loadImageFromResource("resources/coke.png");

        this.itunes = ResourceTools.loadImageFromResource("resources/itunes.png");

        this.itunes1 = new ArrayList<Point>();
        this.itunes1.add(getRandomGridLocation());


    }

    private Point getRandomGridLocation() {
        return new Point((int) (Math.random() * this.grid.getColumns()), (int) (Math.random() * this.grid.getRows()));

    }

    @Override
    public void timerTaskHandler() {
        //System.out.println("Timer");
        if (snake != null) {
            if (moveCounter <= 0) {
                snake.move();
                moveCounter = delay;
                checkSnakeIntersection();
            } else {
                moveCounter--;
            }
//            snake.move();
        }
    }

    private void checkSnakeIntersection() {
        //if the snake location is the same as any apple location
        //then grow the snake and remove the apple
        //later, move apple and make a sound and increase the score
        for (int i = 0; i < this.apples.size(); i++) {
            if (snake.getHead().equals(this.apples.get(i))) {
                System.out.println("apple chomp");
                //grow the snake
                //change the position of the apple
                this.apples.get(i).setLocation(getRandomGridLocation());
                AudioPlayer.play("/resources/apple.wav");
                this.snake.setGrowthCounter(2);
                this.score += 10;
                this.hamburgers.get(i).setLocation(getRandomGridLocation());
                this.frenchfries.get(i).setLocation(getRandomGridLocation());

                //make grow method
                //put 3 Xs when it hits the burger 3x= dead
                //fix burger
                //one pizza kills u
            }
        }
        for (int i = 0; i < this.hamburgers.size(); i++) {
            if (snake.getHead().equals(this.hamburgers.get(i))) {
                System.out.println("lol");
                this.score -= 10;
                this.burgerint++;
                System.out.println("int = " + this.burgerint);

            }
        }
        for (int i = 0; i < this.frenchfries.size(); i++) {
            if (snake.getHead().equals(this.frenchfries.get(i))) {
                this.score -= 30;
                this.burgerint++;

            }
        }
        for (int i = 0; i < this.watermelons.size(); i++) {
            if (snake.getHead().equals(this.watermelons.get(i))) if (this.score == 80) {
                this.score += 30;
//                if (this.score == 310)if (this.score == 200)if (this.score == 80)
                //make u shine 2xpoints 10sec
            }
        }
        for (int i = 0; i < this.cocacola.size(); i++)  {
            if (snake.getHead().equals(this.cocacola.get(i))) if (this.score == 130) if (this.score == 210) {
                this.score -= 50;
                this.burgerint += 2;
                AudioPlayer.play("/resources/slurp.wav");

                
            }
        }
        for (int i = 0; i < this.itunes1.size(); i++) {
            if (snake.getHead().equals(this.itunes1.get(i)))  if (this.score == 40)  {
                this.score += 40;
                AudioPlayer.play("/resources/lepo.wav");}
                else if(this.score == 120){
                                    this.score += 40;

                }             

             
            }
        }

    

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.score += 800000;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.setDirection(Direction.UP);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.setDirection(Direction.LEFT);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.setDirection(Direction.DOWN);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.setDirection(Direction.RIGHT);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            snake.setDirection(Direction.UP);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            snake.setDirection(Direction.LEFT);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            snake.setDirection(Direction.DOWN);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            snake.setDirection(Direction.RIGHT);
            snake.move();
        }

        // if(e.getKeyCode() == KeyEvent.VK_A{
        //  snake.move();
        //}

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(5, 62, 887, 7);
        graphics.fillRect(5, 572, 887, 07);
        graphics.fillRect(2, 62, 07, 517);
        graphics.fillRect(892, 62, 07, 517);
        if (this.apples != null) {
            for (int i = 0; i < this.apples.size(); i++) {
                this.apples.get(i);
                GraphicsPalette.drawApple(graphics, this.grid.getCellPosition(this.apples.get(i)), this.grid.getCellSize());
            }
        }
        if (this.hamburgers != null) {
            for (int i = 0; i < this.hamburgers.size(); i++) {
//                this.hamburgers.get(i);
                graphics.drawImage(burger, this.grid.getCellPosition(this.hamburgers.get(i)).x, this.grid.getCellPosition(this.hamburgers.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
                //graphics.drawImage(burger, this.grid.getCellPosition(this.hamburger.get(i)), this.grid.getCellSize());
            }
        }
        if (this.frenchfries != null) {
            for (int i = 0; i < this.frenchfries.size(); i++) {
                graphics.drawImage(Fries, this.grid.getCellPosition(this.frenchfries.get(i)).x, this.grid.getCellPosition(this.frenchfries.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);

            }
        }

        if (this.grid != null) {
            this.grid.paintComponent(graphics);
            Point cellLocation;
            graphics.setColor(Color.black);
            if (snake != null) {
                for (int i = 0; i < snake.getBody().size(); i++) {
                    cellLocation = grid.getCellPosition(snake.getBody().get(i));
                    graphics.fillOval(cellLocation.x, cellLocation.y, grid.getCellWidth(), grid.getCellHeight());
                }
            }
        }
        graphics.setFont(new Font("Calibri", Font.BOLD, 30));
        graphics.drawString("Score: " + this.score, 50, 50);
        graphics.setFont(new Font("stencil", Font.BOLD, 30));
        graphics.drawString("nake         press ", 400, 47);
        graphics.setFont(new Font("WIDE LATIN", Font.BOLD, 65));
        graphics.drawString("S ", 325, 54);
        graphics.setFont(new Font("BRAGGADOCIO", Font.BOLD, 64));
        graphics.drawString("X ", 496, 57);
        if (this.burgerint == 1) {
            graphics.drawString("x", 720, 50);
        }
        if (this.burgerint == 2) {
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
        if (this.burgerint == 3) {
            graphics.drawString("x", 800, 50);
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
        if (this.score == 80) {
            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        else if (this.score == 200) {
            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        else if (this.score == 310) {
            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        if (this.score == 130)  if (this.score == 210) if (this.score == 350){
            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
//        if (this.score == 220) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//         if (this.score == 350) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
         if (this.score == 40) {
            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
         else if (this.score == 120) {
            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
         
        //grid.getCellPosition(score, score)
    }
}
