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

    private GameState gameState = GameState.PAUSED;
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
    private ArrayList<Point> bananas;
    private Image coke;
    private ArrayList<Point> cocacola;
    private Image hotdog;
    private ArrayList<Point> hotdogs;
    private Image donut;
    private ArrayList<Point> donuts;
    private Image fish;
    private ArrayList<Point> fishes;
    private Image grape;
    private ArrayList<Point> grapes;
    private Image orange;
    private ArrayList<Point> oranges;
    private Image pizza;
    private ArrayList<Point> pizzas;
    private Image watermelon;
    private ArrayList<Point> watermelons;
    private Image strawberry;
    private ArrayList<Point> strawberries;
    private Image pineapple;
    private ArrayList<Point> pineapples;
    private int burgerint = 0;
    private int i;
    private Image itunes;
    private ArrayList<Point> itunes1;
    private Image cake;
    private ArrayList<Point> cakes;
    private Image gameover;

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
        //fish
        this.fish = ResourceTools.loadImageFromResource("resources/fish.png");
        this.fishes = new ArrayList<Point>();
        this.fishes.add(getRandomGridLocation());
        //strawberry
        this.strawberry = ResourceTools.loadImageFromResource("resources/strawberries.png");
        this.strawberries = new ArrayList<Point>();
        this.strawberries.add(getRandomGridLocation());
        //banana
        this.banana = ResourceTools.loadImageFromResource("resources/banana.png");
        this.bananas = new ArrayList<Point>();
        this.bananas.add(getRandomGridLocation());
        //donut
        this.donut = ResourceTools.loadImageFromResource("resources/donut.png");
        this.donuts = new ArrayList<Point>();
        this.donuts.add(getRandomGridLocation());
        //watermelon
        this.watermelon = ResourceTools.loadImageFromResource("resources/watermelon.png");
        this.watermelons = new ArrayList<Point>();
        this.watermelons.add(getRandomGridLocation());
        //coke
        this.cocacola = new ArrayList<Point>();
        this.cocacola.add(getRandomGridLocation());
        this.coke = ResourceTools.loadImageFromResource("resources/coke.png");
        //itunes
        this.itunes = ResourceTools.loadImageFromResource("resources/itunes.png");
        this.itunes1 = new ArrayList<Point>();
        this.itunes1.add(getRandomGridLocation());
        //hot dog
        this.hotdogs = new ArrayList<Point>();
        this.hotdogs.add(getRandomGridLocation());
        this.hotdog = ResourceTools.loadImageFromResource("resources/dog.png");
        //grapes
        this.grapes = new ArrayList<Point>();
        this.grapes.add(getRandomGridLocation());
        this.grape = ResourceTools.loadImageFromResource("resources/grape.png");
        //orange
        this.oranges = new ArrayList<Point>();
        this.oranges.add(getRandomGridLocation());
        this.orange = ResourceTools.loadImageFromResource("resources/orange.png");
        //pizza
        this.pizzas = new ArrayList<Point>();
        this.pizzas.add(getRandomGridLocation());
        this.pizza = ResourceTools.loadImageFromResource("resources/pizza.png");
        //pineapple
        this.pineapples = new ArrayList<Point>();
        this.pineapples.add(getRandomGridLocation());
        this.pineapple = ResourceTools.loadImageFromResource("resources/pineapple.png");
        //cake
        this.cakes = new ArrayList<Point>();
        this.cakes.add(getRandomGridLocation());
        this.cake = ResourceTools.loadImageFromResource("resources/cake.png");
        //gameover
        this.gameover =ResourceTools.loadImageFromResource("resources/game.png");

    }

    private Point getRandomGridLocation() {
        return new Point((int) (Math.random() * this.grid.getColumns()), (int) (Math.random() * this.grid.getRows()));

    }

    @Override
    public void timerTaskHandler() {
        if (this.gameState == GameState.RUNNING) {

            if (snake != null) {
                if (moveCounter <= 0) {
                    snake.move();
                    moveCounter = delay;
                    checkSnakeIntersection();
                } else {
                    moveCounter--;
                }
            }
        }
    }

    private void checkSnakeIntersection() {
        //if the snake location is the same as any apple location
        //then grow the snake and remove the apple
        //later, move apple and make a sound and increase the score
        for (int i = 0; i < this.apples.size(); i++) {
            if (snake.getHead().equals(this.apples.get(i))) {
                System.out.println("apple chomp");
                this.apples.get(i).setLocation(getRandomGridLocation());
                AudioPlayer.play("/resources/apple.wav");
                this.snake.setGrowthCounter(2);
                this.score += 10;
                this.hamburgers.get(i).setLocation(getRandomGridLocation());
                this.frenchfries.get(i).setLocation(getRandomGridLocation());
            }
        }
        for (int i = 0; i < this.hamburgers.size(); i++) {
            if (snake.getHead().equals(this.hamburgers.get(i))) {
                AudioPlayer.play("/resources/lepo.wav");

                System.out.println("lol");
                this.score -= 10;
                this.burgerint++;
                System.out.println("int = " + this.burgerint);
                this.hamburgers.get(i).setLocation(getRandomGridLocation());
            }
        }
        for (int i = 0; i < this.frenchfries.size(); i++) {
            if (snake.getHead().equals(this.frenchfries.get(i))) {
                AudioPlayer.play("/resources/lepo.wav");

                this.score -= 30;
                this.burgerint++;
                this.frenchfries.get(i).setLocation(getRandomGridLocation());
            }
        }
        for (int i = 0; i < this.watermelons.size(); i++) {
            if (snake.getHead().equals(this.watermelons.get(i))) {
                if (this.score == 80) {
                    AudioPlayer.play("/resources/lepo.wav");

                    this.score += 30;
                } else if (this.score == 200) {
                    AudioPlayer.play("/resources/lepo.wav");

                    this.score += 30;
                } else if (this.score == 310) {
                    AudioPlayer.play("/resources/lepo.wav");

                    this.score += 30;
                }
//                if (this.score == 310)if (this.score == 200)if (this.score == 80)
                //make u shine 2xpoints 10sec
            }
        }
        for (int i = 0; i < this.cocacola.size(); i++) {
            if (snake.getHead().equals(this.cocacola.get(i))) {
                if (this.score == 130) {
                    this.score -= 50;
                    this.burgerint += 2;
                    AudioPlayer.play("/resources/slurp.wav");
                } else if (this.score == 220) {
                    this.score -= 50;
                    this.burgerint += 2;
                    AudioPlayer.play("/resources/slurp.wav");
                } else if (this.score == 350) {
                    this.score -= 50;
                    this.burgerint += 2;
                    AudioPlayer.play("/resources/slurp.wav");
                }
            }
        }
        for (int i = 0; i < this.itunes1.size(); i++) {
            if (snake.getHead().equals(this.itunes1.get(i))) {
                if (this.score == 40) {
                    this.score += 30;
                    AudioPlayer.play("/resources/alejandro.wav");
                    //220
                } else if (this.score == 130) {
                    AudioPlayer.play("/resources/alejandro.wav");

                    this.score += 30;

                } else if (this.score == 220) {
                    AudioPlayer.play("/resources/lepo.wav");

                    this.score += 30;
                }
            }
        }
        for (int i = 0; i < this.hotdogs.size(); i++) {
            if (snake.getHead().equals(this.hotdogs.get(i))) {
                if (this.score == 30) {
                    this.burgerint++;
                    AudioPlayer.play("/resources/lepo.wav");

                    this.score -= 30;
                } else if (this.score == 120) {
                    this.burgerint++;
                    AudioPlayer.play("/resources/lepo.wav");

                    this.score -= 30;
                } else if (this.score == 50) {
                    this.burgerint++;
                    AudioPlayer.play("/resources/lepo.wav");

                    this.score -= 30;
                }
                //50,70,140
            }
        }
        for (int i = 0; i < this.donuts.size(); i++) {
            if (snake.getHead().equals(this.donuts.get(i))) {
                if (this.score == 250) {
                    AudioPlayer.play("/resources/lepo.wav");
                    this.burgerint++;
                    this.score -= 20;
                } else if (this.score == 70) {
                    AudioPlayer.play("/resources/lepo.wav");
                    this.burgerint++;
                    this.score -= 20;
                } else if (this.score == 140) {
                    AudioPlayer.play("/resources/lepo.wav");
                    this.burgerint++;
                    this.score -= 20;
                }
            }
        }
        for (int i = 0; i < this.pizzas.size(); i++) {
            if (snake.getHead().equals(this.pizzas.get(i))) {
                if (this.score == 40) {
                    this.burgerint += 3;
                    AudioPlayer.play("/resources/lepo.wav");
                    this.score -= 10;
                } else if (this.score == 130) {
                    AudioPlayer.play("/resources/lepo.wav");
                    this.burgerint += 3;
                    this.score -= 10;
                } else if (this.score == 170) {
                    AudioPlayer.play("/resources/lepo.wav");
                    this.burgerint += 3;
                    this.score -= 10;
                } else if (this.score == 230) {
                    AudioPlayer.play("/resources/lepo.wav");
                    this.burgerint += 3;
                    this.score -= 10;
                }
            }
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {
            this.score += 10;}
            //TOGGLE THE PAUSED/RUNNING STATE
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameState == GameState.RUNNING) {
                gameState = GameState.PAUSED;
            } else if (gameState == GameState.PAUSED){
            gameState = GameState.RUNNING;
            }
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
        else if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            gameState = GameState.ENDED;
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
        //hamburger
        if (this.hamburgers != null) {
            for (int i = 0; i < this.hamburgers.size(); i++) {
                graphics.drawImage(burger, this.grid.getCellPosition(this.hamburgers.get(i)).x, this.grid.getCellPosition(this.hamburgers.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
            }
        }
        //fries
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
        if (this.burgerint == 4) {
            graphics.drawString("x", 800, 50);
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
        if (this.burgerint == 5) {
            graphics.drawString("x", 800, 50);
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
        //watermelon
        if (this.score == 80) {
            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 200) {
            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 310) {
            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        //coke
        if (this.score == 130) {
            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 220) {
            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 350) {
            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        //itunes
        if (this.score == 40) {
            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 130) {
            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 220) {
            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        //hotdog
        if (this.score == 30) {
            graphics.drawImage(hotdog, this.grid.getCellPosition(this.hotdogs.get(i)).x, this.grid.getCellPosition(this.hotdogs.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 50) {
            graphics.drawImage(hotdog, this.grid.getCellPosition(this.hotdogs.get(i)).x, this.grid.getCellPosition(this.hotdogs.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 120) {
            graphics.drawImage(hotdog, this.grid.getCellPosition(this.hotdogs.get(i)).x, this.grid.getCellPosition(this.hotdogs.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        //donut
        if (this.score == 250) {
            graphics.drawImage(donut, this.grid.getCellPosition(this.donuts.get(i)).x, this.grid.getCellPosition(this.donuts.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 70) {
            graphics.drawImage(donut, this.grid.getCellPosition(this.donuts.get(i)).x, this.grid.getCellPosition(this.donuts.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 140) {
            graphics.drawImage(donut, this.grid.getCellPosition(this.donuts.get(i)).x, this.grid.getCellPosition(this.donuts.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        //pizza
        if (this.score == 40) {
            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 130) {
            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 170) {
            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 230) {
            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        //cake
        if (this.score == 60) {
            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 260) {
            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 200) {
            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        } else if (this.score == 330) {
            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
        }
        if (gameState == GameState.ENDED) {
graphics.drawImage(gameover, 20, 40, 400, 300, this);      
graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 64));
        graphics.drawString("BUD", 200, 307);
            
        }
    }
}
