/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import audio.AudioPlayer;
import environment.Environment;
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

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private GameState gameState = GameState.STARTUP;
    private Grid grid;
    private int score = 0;
    private Snake snake;
    private int delay = 0;
    private int moveCounter = delay;
    private GridObjectsCollection gridObjectsCollection;
    private GridObjects apples;
    private static final int[] activeAppleScores = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 81, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
    private static final int APPLE_SCORE = 1;
    private static final int APPLE_BAD_ITEM_EATEN = 0;
    private GridObjects hamburgers;
    private static final int[] activeHamburgerScores = {6, 17, 20, 30, 52, 68, 87};
    private static final int HAMBURGER_SCORE = 0;
    private static final int HAMBURGER_BAD_ITEM_EATEN = 1;
    private GridObjects fries;
    private static final int[] activeFryScores = {6, 9, 22, 39, 48, 78, 97};
    private static final int FRY_SCORE = 0;
    private static final int FRY_BAD_ITEM_EATEN = 2;
    private GridObjects fish;
    private static final int[] activeFishScores = {8, 20, 53, 69, 80};
    private static final int FISH_SCORE = 2;
    private static final int FISH_BAD_ITEM_EATEN = 0;
    private GridObjects banana;
    private static final int[] activeBananaScores = {5, 9, 14, 57, 63, 79, 92};
    private static final int BANANA_SCORE = 2;
    private static final int BANANA_BAD_ITEM_EATEN = 0;
    private GridObjects coke;
    private static final int[] activeCokeScores = {4, 28, 18, 43, 55, 70, 95};
    private static final int COKE_SCORE = 0;
    private static final int COKE_BAD_ITEM_EATEN = 1;
    private GridObjects hotdog;
    private static final int[] activeHotdogScores = {5, 12, 25, 43, 73, 92};
    private static final int HOTDOG_SCORE = 0;
    private static final int HOTDOG_BAD_ITEM_EATEN = 1;
    private GridObjects donut;
    private static final int[] activeDonutScores = {19, 35, 53, 73, 87};
    private static final int DONUT_SCORE = 0;
    private static final int DONUT_BAD_ITEM_EATEN = 3;
    private GridObjects cake;
    private static final int[] activeCakeScores = {7, 30, 47, 56, 80, 87};
    private static final int CAKE_SCORE = 0;
    private static final int CAKE_BAD_ITEM_EATEN = 3;
    private GridObjects egg;
    private static final int[] activeEggScores = {38, 52, 66, 76, 84, 92};
    private static final int EGG_SCORE = 0;
    private static final int EGG_BAD_ITEM_EATEN = 3;
    private GridObjects itunes;
    private static final int[] activeItunesScores = {4, 16, 29, 40, 52, 65, 73, 90};
    private static final int ITUNES_SCORE = 3;
    private static final int ITUNES_BAD_ITEM_EATEN = 0;
    private GridObjects grape;
    private static final int[] activeGrapeScores = {4, 8, 65, 76, 87, 11, 20, 29, 39, 52};
    private static final int GRAPE_SCORE = 1;
    private static final int GRAPE_BAD_ITEM_EATEN = 0;
    private GridObjects orange;
    private static final int[] activeOrangeScores = {3, 7, 10, 19, 26, 35, 47, 61, 72, 84, 91};
    private static final int ORANGE_SCORE = 1;
    private static final int ORANGE_BAD_ITEM_EATEN = 0;
    private GridObjects pancakes;
    private static final int[] activePancakesScores = {20, 34, 46, 58, 80, 93};
    private static final int PANCAKES_SCORE = 0;
    private static final int PANCAKES_BAD_ITEM_EATEN = 2;
    private GridObjects pineapple;
    private static final int[] activePineappleScores = {32, 35, 54, 65, 81, 95};
    private static final int PINEAPPLE_SCORE = 3;
    private static final int PINEAPPLE_BAD_ITEM_EATEN = 0;
    private GridObjects pizza;
    private static final int[] activePizzaScores = {11, 16, 21, 27, 42, 62, 82, 94, 98};
    private static final int PIZZA_SCORE = 0;
    private static final int PIZZA_BAD_ITEM_EATEN = 2;
    private GridObjects radio;
    private static final int[] activeRadioScores = {5, 6, 17, 18, 31};
    private static final int RADIO_SCORE = 2;
    private static final int RADIO_BAD_ITEM_EATEN = 0;
    private GridObjects strawberries;
    private static final int[] activeStrawberriesScores = {16, 29, 47, 66, 82};
    private static final int STRAWBERRIES_SCORE = 3;
    private static final int STRAWBERRIES_BAD_ITEM_EATEN = 0;
    private GridObjects watermelon;
    private static final int[] activeWatermelonScores = {12, 40, 56, 74};
    private static final int WATERMELON_SCORE = 1;
    private static final int WATERMELON_BAD_ITEM_EATEN = 0;
    private GridObjects godlike;
    private static final int[] activeGodlikeScores = {57, 58};
    private static final int GODLIKE_SCORE = 3;
    private static final int GODLIKE_BAD_ITEM_EATEN = 0;
    private GridObjects dominating;
    private static final int[] activeDominatingScores = {70, 71};
    private static final int DOMINATING_SCORE = 2;
    private static final int DOMINATING_BAD_ITEM_EATEN = 0;
    private GridObjects unstopable;
    private static final int[] activeUnstopableScores = {80, 82};
    private static final int UNSTOPABLE_SCORE = 1;
    private static final int UNSTOPABLE_BAD_ITEM_EATEN = 0;
    private int itemsEaten = 0;
    private Image gameover;
    private Image boom;
    private Image start;
    private Image start2;
    private Image snakecartoon;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Initialize">
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

        this.snake = new Snake();
        resetSnakePosition();

        gridObjectsCollection = new GridObjectsCollection();
        //apples
        apples = new GridObjects(generateRandomGridCellCoordinates(1), activeAppleScores, APPLE_SCORE, APPLE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/apple.png"), "/resources/apple.wav", 2);
        gridObjectsCollection.addToCollection(apples);
        //burger
        hamburgers = new GridObjects(generateRandomGridCellCoordinates(1), activeHamburgerScores, HAMBURGER_SCORE, HAMBURGER_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/burger.png"), "/resources/zombiebite.wav", 3);
        gridObjectsCollection.addToCollection(hamburgers);
        //fries
        fries = new GridObjects(generateRandomGridCellCoordinates(1), activeFryScores, FRY_SCORE, FRY_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/fries.png"), "/resources/crunchbite.wav", 2);
        gridObjectsCollection.addToCollection(fries);
        //fish
        fish = new GridObjects(generateRandomGridCellCoordinates(1), activeFishScores, FISH_SCORE, FISH_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/tilapia.png"), "/resources/apple.wav", 2);
        gridObjectsCollection.addToCollection(fish);
        //oranges
        orange = new GridObjects(generateRandomGridCellCoordinates(1), activeOrangeScores, ORANGE_SCORE, ORANGE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/orange.png"), "/resources/apple.wav", 2);
        gridObjectsCollection.addToCollection(orange);
        //grape
        grape = new GridObjects(generateRandomGridCellCoordinates(1), activeGrapeScores, GRAPE_SCORE, GRAPE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/grape.png"), "/resources/funnybite.wav", 2);
        gridObjectsCollection.addToCollection(grape);
        //banana
        banana = new GridObjects(generateRandomGridCellCoordinates(1), activeBananaScores, BANANA_SCORE, BANANA_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/banana.png"), "/resources/apple.wav", 1);
        gridObjectsCollection.addToCollection(banana);
        //pineapple
        pineapple = new GridObjects(generateRandomGridCellCoordinates(1), activePineappleScores, PINEAPPLE_SCORE, PINEAPPLE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/pineapple.png"), "/resources/apple.wav", 1);
        gridObjectsCollection.addToCollection(pineapple);
        //strawberry
        strawberries = new GridObjects(generateRandomGridCellCoordinates(1), activeStrawberriesScores, STRAWBERRIES_SCORE, STRAWBERRIES_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/strawberries.png"), "/resources/wetbite.wav", 1);
        gridObjectsCollection.addToCollection(strawberries);
        //egg
        egg = new GridObjects(generateRandomGridCellCoordinates(1), activeEggScores, EGG_SCORE, EGG_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/egg.png"), "/resources/apple.wav", 0);
        gridObjectsCollection.addToCollection(egg);
        //pizza
        pizza = new GridObjects(generateRandomGridCellCoordinates(1), activePizzaScores, PIZZA_SCORE, PIZZA_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/pizza.png"), "/resources/apple.wav", 2);
        gridObjectsCollection.addToCollection(pizza);
        //pancakes
        pancakes = new GridObjects(generateRandomGridCellCoordinates(1), activePancakesScores, PANCAKES_SCORE, PANCAKES_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/pancakes.png"), "/resources/apple.wav", 0);
        gridObjectsCollection.addToCollection(pancakes);
        //cake
        cake = new GridObjects(generateRandomGridCellCoordinates(1), activeCakeScores, CAKE_SCORE, CAKE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/cake.png"), "/resources/funnybite.wav", 0);
        gridObjectsCollection.addToCollection(cake);
        //itunes
        itunes = new RandomSoundGridObjects(generateRandomGridCellCoordinates(1), activeItunesScores, ITUNES_SCORE, ITUNES_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/itunes.png"), "/resources/apple.wav", 2);
        gridObjectsCollection.addToCollection(itunes);
        //radio
        radio = new RandomSoundGridObjects(generateRandomGridCellCoordinates(1), activeRadioScores, RADIO_SCORE, RADIO_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/radio.png"), "/resources/apple.wav", 1);
        gridObjectsCollection.addToCollection(radio);
        //coke
        coke = new GridObjects(generateRandomGridCellCoordinates(1), activeCokeScores, COKE_SCORE, COKE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/coke.png"), "/resources/slurp.wav", 3);
        gridObjectsCollection.addToCollection(coke);
        //dog
        hotdog = new GridObjects(generateRandomGridCellCoordinates(1), activeHotdogScores, HOTDOG_SCORE, HOTDOG_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/dog.png"), "/resources/apple.wav", 3);
        gridObjectsCollection.addToCollection(hotdog);
        //        //donut
        donut = new GridObjects(generateRandomGridCellCoordinates(1), activeDonutScores, DONUT_SCORE, DONUT_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/donut.png"), "/resources/apple.wav", 0);
        gridObjectsCollection.addToCollection(donut);
        //        //watermelon
        watermelon = new GridObjects(generateRandomGridCellCoordinates(1), activeWatermelonScores, WATERMELON_SCORE, WATERMELON_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/watermelon.png"), "/resources/apple.wav", 1);
        gridObjectsCollection.addToCollection(watermelon);
        godlike = new GridObjects(generateRandomGridCellCoordinates(1), activeGodlikeScores, GODLIKE_SCORE, GODLIKE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/strawberries.png"), "/resources/godlike.wav", 1);
        gridObjectsCollection.addToCollection(godlike);
        dominating = new GridObjects(generateRandomGridCellCoordinates(1), activeDominatingScores, DOMINATING_SCORE, DOMINATING_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/banana.png"), "/resources/dominating.wav", 1);
        gridObjectsCollection.addToCollection(dominating);
        unstopable = new GridObjects(generateRandomGridCellCoordinates(1), activeUnstopableScores, UNSTOPABLE_SCORE, UNSTOPABLE_BAD_ITEM_EATEN, ResourceTools.loadImageFromResource("resources/apples.png"), "/resources/unstopable.wav", 1);
        gridObjectsCollection.addToCollection(unstopable);

        //gameover
        this.gameover = ResourceTools.loadImageFromResource("resources/game.png");
        this.boom = ResourceTools.loadImageFromResource("resources/boom.png");
        this.start = ResourceTools.loadImageFromResource("resources/start.png");
        this.start2 = ResourceTools.loadImageFromResource("resources/start2.png");
        this.snakecartoon = ResourceTools.loadImageFromResource("resources/snake.png");


    }
    //</editor-fold>

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
        if (this.getGameState() == GameState.RUNNING) {

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
        if (snake.getHead() != null) {
            if (snake.getDirection() == Direction.RIGHT) {
                if (snake.getHead().x >= this.grid.getColumns()) {
                    //snake.getHead().x = -3;
                    setGameState(GameState.HIT_WALL);
                }
            }
            if (snake.getDirection() == Direction.LEFT) {
                if (snake.getHead().x <= -1) {
                    setGameState(GameState.HIT_WALL);
                }
            }
            if (snake.getDirection() == Direction.DOWN) {
                if (snake.getHead().y >= this.grid.getRows()) {
                    setGameState(GameState.HIT_WALL);
                }
            }
            if (snake.getDirection() == Direction.UP) {
                if (snake.getHead().y <= -1) {
                    setGameState(GameState.HIT_WALL);
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
    public void setScore(int newScore) {
        this.score = newScore;
        if (this.score >= 100) {
            this.setGameState(GameState.HIGH_SCORE);

        }
    }

    private void checkSnakeIntersection() {

        if (snake.checkSelfHit()) {
            this.setGameState(GameState.EAT_YOURSELF);
        }

        for (GridObjects gridObjects : gridObjectsCollection.getActiveCollection(getScore())) {
            //this gives us the active objects (based on score)
            for (int j = 0; j < gridObjects.size(); j++) {

                if (snake.getHead().equals(gridObjects.getCellCoordinates().get(j))) {
                    gridObjects.getCellCoordinates().get(j).setLocation(getRandomGridLocation()); //move the element that intersected with the snakes head
                    addToScore(gridObjects.getScore());  //increment the score
                    addToItemsEaten(gridObjects.getBadItemEaten());  //increment the 'bad item eaten' counter               
                    AudioPlayer.play(gridObjects.getSoundResource());//play a noise
                    snake.grow(gridObjects.getGrowthCounter());

                }
            }
        }








    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {
            this.setScore(this.getScore() + 80);
        }
        //TOGGLE THE PAUSED/RUNNING STATE
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (getGameState() == GameState.RUNNING) {
                setGameState(GameState.PAUSED);
            } else if ((getGameState() == GameState.STARTUP) || (getGameState() == GameState.PAUSED)) {
                setGameState(GameState.RUNNING);
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
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            setGameState(GameState.STARTUP);
        } else if (e.getKeyCode() == KeyEvent.VK_C) {
            snake.changeColor();
        }

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("Click x = " + e.getPoint().x + ", y = " + e.getPoint().y);
        if (getGameState() == GameState.STARTUP) {
            if ((e.getPoint().x >= 500) && (e.getPoint().x <= 830)
                    && (e.getPoint().y >= 450) && (e.getPoint().y <= 520)) {
                setGameState(GameState.RUNNING);
            }
        }
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(5, 62, 887, 7);
        graphics.fillRect(5, 572, 887, 07);
        graphics.fillRect(2, 62, 07, 517);
        graphics.fillRect(892, 62, 07, 517);


        //only draw the active objects (this will depend on the score)
        for (GridObjects gridObjects : gridObjectsCollection.getActiveCollection(getScore())) {
            for (int j = 0; j < gridObjects.size(); j++) {
                graphics.drawImage(gridObjects.getImage(), this.grid.getCellPosition(gridObjects.getCellCoordinates().get(j)).x, this.grid.getCellPosition(gridObjects.getCellCoordinates().get(j)).y, this.grid.getCellSize().x, this.grid.getCellSize().y, this);
            }
        }

        if (this.grid != null) {
            this.grid.paintComponent(graphics);
            Point cellLocation;
            graphics.setColor(Color.black);
            if (snake != null) {
                for (int i = 0; i < snake.getBody().size(); i++) {
                    graphics.setColor(snake.getColor());

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

        if (getGameState() == GameState.EAT_YOURSELF) {
            graphics.drawImage(gameover, 20, 80, 800, 350, this);
            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 34));
            graphics.drawString("Do you try to eat yourself this often?", 100, 507);
        }
        if (getGameState() == GameState.ENDED) {
            graphics.drawImage(gameover, 20, 80, 800, 350, this);
            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 25));
            graphics.drawString("HEY! HEY! CHILL BUD, THIS WAY YOU ARE GONNA GET FAT", 20, 507);
        }
        if (getGameState() == GameState.PAUSED) {

            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 34));
            graphics.setColor(Color.BLACK);
            graphics.drawString("PRESS SPACE TO CONTINUE", 50, 207);
        }
        if (getGameState() == GameState.STARTUP) {
            graphics.setColor(new Color(124, 205, 124));
            graphics.fillRect(0, 0, 300, 580);
            graphics.fillRect(0, 60, 900, 520);
            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 65));
            graphics.setColor(Color.black);
            graphics.fillRect(0, 60, 900, 520);
            graphics.setColor(Color.green);
            graphics.drawImage(start2, 390, 80, 540, 390, this);
            graphics.drawString("CLICK", 550, 400);

            graphics.drawImage(start, 390, 80, 540, 440, this);
        }
        if (getGameState() == GameState.HIT_WALL) {
            graphics.drawImage(boom, 10, 100, 400, 320, this);
            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 34));
            graphics.drawString(" Crashed into a wall!", 450, 257);
            graphics.drawString(" Are you blind, BUD?", 450, 287);

        }
        if (getGameState() == GameState.HIGH_SCORE) {
            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 34));
            graphics.drawString("Congratulations!", 300, 257);
            graphics.drawString("You just Maxed out on points.", 300, 287);
            graphics.setFont(new Font("COMIC AS SUNS", Font.BOLD, 14));
            graphics.drawString("Made by: Breno Chan", 300, 310);
            graphics.drawString("Teacher: Kevin Lawrence", 300, 327);

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
            this.setGameState(GameState.ENDED);
        }
    }

    /**
     * @param items the itemsEaten to set
     */
    public void addToItemsEaten(int items) {
        setItemsEaten(this.itemsEaten + items);
        if (this.itemsEaten >= 3) {
            this.setGameState(GameState.ENDED);


        }
    }

    /**
     * @return the gameState
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * @param newGameState the gameState to set
     */
    public void setGameState(GameState newGameState) {
        if (this.gameState != newGameState) {
            this.gameState = newGameState;

            if (newGameState == GameState.HIT_WALL) {
                AudioPlayer.play("/resources/car.wav");
            } else if (newGameState == GameState.STARTUP) {
                resetSnakePosition();

                this.score = 0;
                this.itemsEaten = 0;
            } else if (newGameState == GameState.EAT_YOURSELF) {
                AudioPlayer.play("/resources/fail.wav");
            }

        }
    }

    private void resetSnakePosition() {
        if (snake != null) {
            snake.getBody().clear();

            snake.getBody().add(new Point(5, 5));
            snake.getBody().add(new Point(5, 4));
            snake.getBody().add(new Point(5, 3));
            snake.getBody().add(new Point(4, 3));
            snake.getBody().add(new Point(4, 2));
            snake.getBody().add(new Point(3, 2));

            snake.setDirection(Direction.RIGHT);

        }
    }

    public int getRandomInt() {
        return (int) (Math.random() * 20) + 1;
    }
}
