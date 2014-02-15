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

    private int[] orangesActive = {10, 19, 27, 35};
    private GameState gameState = GameState.PAUSED;
    private Grid grid;
    private int score = 0;
    private Snake snake;
    private ArrayList<Point> apples;
    private int delay = 3;
    private int moveCounter = delay;
    private Image burger;
//    private ArrayList<Point> hamburgers;
    private GridObjectsCollection gridObjectsCollection;
    private GridObjects hamburgers;
    private static final int[] activeHamburgerScores = {0, 1, 3, 5, 17, 20, 30};
    private static final int HAMBURGER_SCORE = 1;
    private static final int HAMBURGER_BAD_ITEM_EATEN = 0;
    private GridObjects fries;
    private static final int[] activeFryScores = {0, 2, 4, 6, 9, 22, 39};
    private static final int FRY_SCORE = -1;
    private static final int FRY_BAD_ITEM_EATEN = 1;
//    private Image Fries;
//    private ArrayList<Point> frenchfries;
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
    private int itemsEaten = 0;
//    private int i;
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

        gridObjectsCollection = new GridObjectsCollection();

        //burger
//        int[] activeHamburgerScores = {0, 1, 3, 5, 17, 20, 30};
        hamburgers = new GridObjects(generateRandomGridCellCoordinates(1), activeHamburgerScores, HAMBURGER_SCORE, HAMBURGER_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/burger.png"));
        gridObjectsCollection.addToCollection(hamburgers);
//        this.hamburgers = new ArrayList<Point>();
//        this.hamburgers.add(getRandomGridLocation());
//        this.burger = ResourceTools.loadImageFromResource("resources/burger.png");

        //fries
        fries = new GridObjects(generateRandomGridCellCoordinates(1), activeFryScores, FRY_SCORE, FRY_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/fries.png"));
        gridObjectsCollection.addToCollection(fries);

        //        this.Fries = ResourceTools.loadImageFromResource("resources/fries.png");
//        this.frenchfries = new ArrayList<Point>();
//        this.frenchfries.add(getRandomGridLocation());

//        //fish
//        this.fish = ResourceTools.loadImageFromResource("resources/fish.png");
//        this.fishes = new ArrayList<Point>();
//        this.fishes.add(getRandomGridLocation());
//        //strawberry
//        this.strawberry = ResourceTools.loadImageFromResource("resources/strawberries.png");
//        this.strawberries = new ArrayList<Point>();
//        this.strawberries.add(getRandomGridLocation());
//        //banana
//        this.banana = ResourceTools.loadImageFromResource("resources/banana.png");
//        this.bananas = new ArrayList<Point>();
//        this.bananas.add(getRandomGridLocation());
//        //donut
//        this.donut = ResourceTools.loadImageFromResource("resources/donut.png");
//        this.donuts = new ArrayList<Point>();
//        this.donuts.add(getRandomGridLocation());
//        //watermelon
//        this.watermelon = ResourceTools.loadImageFromResource("resources/watermelon.png");
//        this.watermelons = new ArrayList<Point>();
//        this.watermelons.add(getRandomGridLocation());
//        //coke
//        this.cocacola = new ArrayList<Point>();
//        this.cocacola.add(getRandomGridLocation());
//        this.coke = ResourceTools.loadImageFromResource("resources/coke.png");
//        //itunes
//        this.itunes = ResourceTools.loadImageFromResource("resources/itunes.png");
//        this.itunes1 = new ArrayList<Point>();
//        this.itunes1.add(getRandomGridLocation());
//        //hot dog
//        this.hotdogs = new ArrayList<Point>();
//        this.hotdogs.add(getRandomGridLocation());
//        this.hotdog = ResourceTools.loadImageFromResource("resources/dog.png");
//        //grapes
//        this.grapes = new ArrayList<Point>();
//        this.grapes.add(getRandomGridLocation());
//        this.grape = ResourceTools.loadImageFromResource("resources/grape.png");
//        //orange
//        this.oranges = new ArrayList<Point>();
//        this.oranges.add(getRandomGridLocation());
//        this.orange = ResourceTools.loadImageFromResource("resources/orange.png");
//        //pizza
//        this.pizzas = new ArrayList<Point>();
//        this.pizzas.add(getRandomGridLocation());
//        this.pizza = ResourceTools.loadImageFromResource("resources/pizza.png");
//        //pineapple
//        this.pineapples = new ArrayList<Point>();
//        this.pineapples.add(getRandomGridLocation());
//        this.pineapple = ResourceTools.loadImageFromResource("resources/pineapple.png");
//        //cake
//        this.cakes = new ArrayList<Point>();
//        this.cakes.add(getRandomGridLocation());
//        this.cake = ResourceTools.loadImageFromResource("resources/cake.png");
        //gameover
        this.gameover = ResourceTools.loadImageFromResource("resources/game.png");

    }

    //<editor-fold defaultstate="collapsed" desc="Grid Convenience Methods">
    private Point getRandomGridLocation() {
        return new Point((int) (Math.random() * this.grid.getColumns()), (int) (Math.random() * this.grid.getRows()));
    }

    public ArrayList<Point> generateRandomGridCellCoordinates(int numberOfCoordinates) {
        return generateRandomCellCoordinates(numberOfCoordinates, 0, this.grid.getCellWidth(), 0, this.grid.getCellHeight());
    }

    public static ArrayList<Point> generateRandomCellCoordinates(int numberOfCoordinates, int minX, int maxX, int minY, int maxY) {
        ArrayList<Point> cellCoordinates = new ArrayList<Point>();

        for (int i = 0; i < numberOfCoordinates; i++) {
            cellCoordinates.add(new Point(getRandomInteger(minX, maxX), getRandomInteger(minY, maxY)));
        }
        return cellCoordinates;
    }

    public static int getRandomInteger(int minimumValue, int maximumValue) {
        return (int) ((Math.random() * (maximumValue - minimumValue)) + minimumValue);
    }
    //</editor-fold>

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

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void addToScore(int score) {
        setScore(this.score + score);
    }

    /**
     * @param score the score to set
     */
//    public void setScore(int newScore, ObstacleType obstacleType) {
    public void setScore(int newScore) {

//        switch (obstacleType) {
//            case WATERMELONS:
//                if (checkScoreLevel(this.score, newScore, 4)) { // should be 80
//                    System.out.println("passed 4 boundary");
//                } else if (checkScoreLevel(this.score, newScore, 8)) {  //shoud be 200
//                    System.out.println("passed 8 boundary");
//                } else if (checkScoreLevel(this.score, newScore, 12)) {  //shoud be 310
//                    System.out.println("passed 8 boundary");
//                }
//                break;
//
//            case HAMBURGER:
//
//
//                break;
//
//            case COKE:
//
//
//                break;
//
//            case ITUNES:
//
//
//                break;
//
//
//
//        }
        this.score = newScore;
    }

    private boolean checkScoreLevel(int oldScore, int newScore, int scoreLevel) {
        return ((oldScore < scoreLevel) && (newScore >= scoreLevel));
    }

    private void checkSnakeIntersection() {
        //if the snake location is the same as any apple location
        //then grow the snake and remove the apple
        //later, move apple and make a sound and increase the score
        for (int i = 0; i < this.apples.size(); i++) {
            if (snake.getHead().equals(this.apples.get(i))) {
                System.out.println("apple chomp");

                this.apples.get(i).setLocation(getRandomGridLocation());
                this.snake.setGrowthCounter(2);
//                this.setScore(this.getScore() + 1, ObstacleType.APPLE);
                addToScore(1);

                AudioPlayer.play("/resources/apple.wav");
            }
        }

        for (GridObjects gridObjects : gridObjectsCollection.getActiveCollection(getScore())) {
            //this gives us the active objects (based on score)
            for (int j = 0; j < gridObjects.size(); j++) {

                if (snake.getHead().equals(gridObjects.getCellCoordinates().get(j))) {
                    gridObjects.getCellCoordinates().get(j).setLocation(getRandomGridLocation()); //move the element that intersected with the snakes head
                    addToScore(gridObjects.getScore());  //increment the score
                    addToItemsEaten(gridObjects.getBadItemEaten());  //increment the 'bad item eaten' counter               
                    //play a noise

                }
            }
        }


//        for (int i = 0; i < hamburgers.size(); i++) {
//            if (snake.getHead().equals(hamburgers.getCellCoordinates().get(i))) {
//                this.hamburgers.getCellCoordinates().get(i).setLocation(getRandomGridLocation());
//
//                System.out.println("lol");
//                this.setScore(this.getScore() - 10, ObstacleType.HAMBURGER);
//                this.setItemsEaten(this.getItemsEaten() + 1);
//                System.out.println("int = " + this.getItemsEaten());
//            }
//        }
//
//        for (int i = 0; i < this.frenchfries.size(); i++) {
//            if (snake.getHead().equals(this.frenchfries.get(i))) {
//                this.frenchfries.get(i).setLocation(getRandomGridLocation());
//
//                this.setScore(this.getScore() - 30, ObstacleType.FRENCH_FRY);
//                this.setItemsEaten(this.getItemsEaten() + 1);
//            }
//        }
//
//        for (int i = 0; i < this.watermelons.size(); i++) {
//            if (snake.getHead().equals(this.watermelons.get(i))) {
//                this.setScore(this.getScore() + 2, ObstacleType.WATERMELONS);
//            }
//        }
//
//        for (int i = 0; i < this.cocacola.size(); i++) {
//            if (snake.getHead().equals(this.cocacola.get(i))) {
//                System.out.println("Ate Coka-cola");
//
//                this.cocacola.get(i).setLocation(getRandomGridLocation());
//                this.setItemsEaten(this.getItemsEaten() + 2);
//
//                AudioPlayer.play("/resources/slurp.wav");
//            }

//                if (this.getScore() == 4) {
//                    System.out.println("HELP");
//                    this.setItemsEaten(this.getItemsEaten() + 2);
//                    AudioPlayer.play("/resources/slurp.wav");
//                    this.cocacola.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 18) {
//                    this.setItemsEaten(this.getItemsEaten() + 2);
//                    AudioPlayer.play("/resources/slurp.wav");
//                    this.cocacola.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 28) {
//                    this.setItemsEaten(this.getItemsEaten() + 2);
//                    AudioPlayer.play("/resources/slurp.wav");
//                    this.cocacola.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 43) {
//                    this.setItemsEaten(this.getItemsEaten() + 2);
//                    AudioPlayer.play("/resources/slurp.wav");
//                    this.cocacola.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 55) {
//                    this.setItemsEaten(this.getItemsEaten() + 2);
//                    AudioPlayer.play("/resources/slurp.wav");
//                    this.cocacola.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 70) {
//                    this.setItemsEaten(this.getItemsEaten() + 2);
//                    AudioPlayer.play("/resources/slurp.wav");
//                    this.cocacola.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 95) {
//                    this.setItemsEaten(this.getItemsEaten() + 2);
//                    AudioPlayer.play("/resources/slurp.wav");
//                    this.cocacola.get(i).setLocation(getRandomGridLocation());
//                }
//        }
//        }
//        for (int i = 0; i < this.grapes.size(); i++) {
//            if (snake.getHead().equals(this.grapes.get(i))) {
//                this.grapes.get(i).setLocation(getRandomGridLocation());
//                this.setScore(this.getScore() + 1, ObstacleType.GRAPE);
//            }
//        }

        //BRENO - I don't understand this logic: why do you only want to increase 
        // the score when you are at other scores?
        // If this is because you want the grapes to only appear at certain times
        // then you should use a boolean flag for "are the grapes visible?"


//                if (this.getScore() == 4) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 8) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 11) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 20) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 29) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 39) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 52) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 65) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 76) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 87) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 98) {
//                    this.setScore(this.getScore() + 1);
//                    this.grapes.get(i).setLocation(getRandomGridLocation());
//                }

//        for (int i = 0; i < this.oranges.size(); i++) {
//            if (snake.getHead().equals(this.oranges.get(i))) {
//                if (this.getScore() == 3) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 7) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 10) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 19) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 26) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 35) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                } else if (this.getScore() == 47) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 61) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 72) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 84) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                }else if (this.getScore() == 91) {
//                    this.setScore(this.getScore() + 1);
//                    this.oranges.get(i).setLocation(getRandomGridLocation());
//                }
//            }
//        }
//
//        for (int i = 0; i < this.itunes1.size(); i++) {
//            if (snake.getHead().equals(this.itunes1.get(i))) {
//                
//                
//            }
//        }
//                if (this.getScore() == 40) {
//                    this.setScore(this.getScore() + 30);
//                    AudioPlayer.play("/resources/alejandro.wav");
//                    //220
//                } else if (this.getScore() == 130) {
//                    AudioPlayer.play("/resources/alejandro.wav");
//
//                    this.setScore(this.getScore() + 30);
//
//                } else if (this.getScore() == 220) {
//
//                    this.setScore(this.getScore() + 30);
//                }

//        for (int i = 0;
//                i
//                < this.hotdogs.size();
//                i++) {
//            if (snake.getHead().equals(this.hotdogs.get(i))) {
//                if (this.getScore() == 30) {
//                    this.setItemsEaten(this.getItemsEaten() + 1);
//
//                    this.setScore(this.getScore() - 30);
//                } else if (this.getScore() == 120) {
//                    this.setItemsEaten(this.getItemsEaten() + 1);
//
//                    this.setScore(this.getScore() - 30);
//                } else if (this.getScore() == 50) {
//                    this.setItemsEaten(this.getItemsEaten() + 1);
//
//                    this.setScore(this.getScore() - 30);
//                }
        //50,70,140
//            }
//        }
//        for (int i = 0;
//                i
//                < this.donuts.size();
//                i++) {
//            if (snake.getHead().equals(this.donuts.get(i))) {
//                if (this.getScore() == 250) {
//                    this.setItemsEaten(this.getItemsEaten() + 1);
//                    this.setScore(this.getScore() - 20);
//                } else if (this.getScore() == 70) {
//                    this.setItemsEaten(this.getItemsEaten() + 1);
//                    this.setScore(this.getScore() - 20);
//                } else if (this.getScore() == 140) {
//                    this.setItemsEaten(this.getItemsEaten() + 1);
//                    this.setScore(this.getScore() - 20);
//                }
//            }
//        }
//        for (int i = 0;
//                i
//                < this.pizzas.size();
//                i++) {
//            if (snake.getHead().equals(this.pizzas.get(i))) {
//                if (this.getScore() == 40) {
//                    this.setItemsEaten(this.getItemsEaten() + 3);
//                } else if (this.getScore() == 130) {
//                    this.setItemsEaten(this.getItemsEaten() + 3);
//                } else if (this.getScore() == 170) {
//                    this.setItemsEaten(this.getItemsEaten() + 3);
//                } else if (this.getScore() == 230) {
//                    this.setItemsEaten(this.getItemsEaten() + 3);
//                }
//            }
//        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_P) {
//            this.setScore(this.getScore() + 2);
//        }
        //TOGGLE THE PAUSED/RUNNING STATE
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameState == GameState.RUNNING) {
                gameState = GameState.PAUSED;
            } else if (gameState == GameState.PAUSED) {
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
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
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
                GraphicsPalette.drawApple(graphics, this.grid.getCellPosition(this.apples.get(i)), this.grid.getCellSize());
            }
        }
        
        
        //only draw the active objects (this will depend on the score)
        for (GridObjects gridObjects : gridObjectsCollection.getActiveCollection(getScore())) {
            for (int j = 0; j < gridObjects.size(); j++) {
                graphics.drawImage(gridObjects.getImage(), this.grid.getCellPosition(gridObjects.getCellCoordinates().get(j)).x, this.grid.getCellPosition(gridObjects.getCellCoordinates().get(j)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
            }
        }

        
        
//        //hamburger
//        if (this.hamburgers != null) {
//            for (int i = 0; i < this.hamburgers.size(); i++) {
//                graphics.drawImage(burger, this.grid.getCellPosition(this.hamburgers.get(i)).x, this.grid.getCellPosition(this.hamburgers.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//            }
//        }
//        //fries
//        if (this.frenchfries != null) {
//            for (int i = 0; i < this.frenchfries.size(); i++) {
//                graphics.drawImage(Fries, this.grid.getCellPosition(this.frenchfries.get(i)).x, this.grid.getCellPosition(this.frenchfries.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//            }
//        }
//        
        
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
        graphics.drawString("Score: " + this.getScore(), 50, 50);
        graphics.setFont(new Font("stencil", Font.BOLD, 30));
        graphics.drawString("nake         press ", 400, 47);
        graphics.setFont(new Font("WIDE LATIN", Font.BOLD, 65));
        graphics.drawString("S ", 325, 54);
        graphics.setFont(new Font("BRAGGADOCIO", Font.BOLD, 64));
        graphics.drawString("X ", 496, 57);
        if (this.getItemsEaten() == 1) {
            graphics.drawString("x", 720, 50);
        }
        if (this.getItemsEaten() == 2) {
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
        if (this.getItemsEaten() == 3) {
            graphics.drawString("x", 800, 50);
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
        if (this.getItemsEaten() == 4) {
            graphics.drawString("x", 800, 50);
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
        if (this.getItemsEaten() == 5) {
            graphics.drawString("x", 800, 50);
            graphics.drawString("x", 760, 50);
            graphics.drawString("x", 720, 50);
        }
//        //watermelon
//        if (this.getScore() == 3) {
//            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 8) {
//            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 310) {
//            graphics.drawImage(watermelon, this.grid.getCellPosition(this.watermelons.get(i)).x, this.grid.getCellPosition(this.watermelons.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //coke
//        if (this.getScore() == 4) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 18) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 28) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 43) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 55) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 70) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 95) {
//            graphics.drawImage(coke, this.grid.getCellPosition(this.cocacola.get(i)).x, this.grid.getCellPosition(this.cocacola.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //orange
//        if (this.getScore() == 3) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 7) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 10) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 19) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 26) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 35) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 47) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 61) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 72) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 84) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 91) {
//            graphics.drawImage(orange, this.grid.getCellPosition(this.oranges.get(i)).x, this.grid.getCellPosition(this.oranges.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //itunes
//        if (this.getScore() == 3) {
//            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 130) {
//            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 220) {
//            graphics.drawImage(itunes, this.grid.getCellPosition(this.itunes1.get(i)).x, this.grid.getCellPosition(this.itunes1.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //hotdog
//        if (this.getScore() == 30) {
//            graphics.drawImage(hotdog, this.grid.getCellPosition(this.hotdogs.get(i)).x, this.grid.getCellPosition(this.hotdogs.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 50) {
//            graphics.drawImage(hotdog, this.grid.getCellPosition(this.hotdogs.get(i)).x, this.grid.getCellPosition(this.hotdogs.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 120) {
//            graphics.drawImage(hotdog, this.grid.getCellPosition(this.hotdogs.get(i)).x, this.grid.getCellPosition(this.hotdogs.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //donut
//        if (this.getScore() == 250) {
//            graphics.drawImage(donut, this.grid.getCellPosition(this.donuts.get(i)).x, this.grid.getCellPosition(this.donuts.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 70) {
//            graphics.drawImage(donut, this.grid.getCellPosition(this.donuts.get(i)).x, this.grid.getCellPosition(this.donuts.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 140) {
//            graphics.drawImage(donut, this.grid.getCellPosition(this.donuts.get(i)).x, this.grid.getCellPosition(this.donuts.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //pizza
//        if (this.getScore() == 40) {
//            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 130) {
//            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 170) {
//            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 230) {
//            graphics.drawImage(pizza, this.grid.getCellPosition(this.pizzas.get(i)).x, this.grid.getCellPosition(this.pizzas.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //grapes
//        if (this.getScore() == 4) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 8) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 11) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 20) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 29) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 39) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 52) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 65) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 76) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 87) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 98) {
//            graphics.drawImage(grape, this.grid.getCellPosition(this.grapes.get(i)).x, this.grid.getCellPosition(this.grapes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
//        //cake
//        if (this.getScore() == 60) {
//            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 260) {
//            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 200) {
//            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        } else if (this.getScore() == 330) {
//            graphics.drawImage(cake, this.grid.getCellPosition(this.cakes.get(i)).x, this.grid.getCellPosition(this.cakes.get(i)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
//        }
        if (gameState == GameState.ENDED) {
            graphics.drawImage(gameover, 20, 80, 850, 450, this);
            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 34));
            graphics.drawString("BUD", 700, 507);

        }
    }

    /**
     * @return the itemsEaten
     */
    public int getItemsEaten() {
        return itemsEaten;
    }

    /**
     * @param items the itemsEaten to set
     */
    public void setItemsEaten(int items) {
        this.itemsEaten = items;
        if (itemsEaten >= 3) {
            this.gameState = GameState.ENDED;
        }
    }
    
    /**
     * @param items the itemsEaten to set
     */
    public void addToItemsEaten(int items) {
        setItemsEaten( this.itemsEaten + items);
    }
}
