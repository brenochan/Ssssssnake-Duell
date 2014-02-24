/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class GridObjects {

    public GridObjects(ArrayList<Point> cellCoordinates, int[] activeScores, int score, int badItemEaten, Image image, String soundResource, int growthCounter) {
        this.cellCoordinates = cellCoordinates;
        this.activeScores = activeScores;
        this.score = score;
        this.badItemEaten = badItemEaten;
        this.image = image;
        this.soundResource = soundResource;
        this.growthCounter = growthCounter;
    }

//<editor-fold defaultstate="collapsed" desc="Static Methods">
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
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<Point> cellCoordinates;
    private int[] activeScores;
    private Image image;
    private int score;
    private int badItemEaten;
    private String soundResource = "";
    private int growthCounter = 0;

    /**
     * @return the cellCoordinates
     */
    public ArrayList<Point> getCellCoordinates() {
        return cellCoordinates;
    }

    /**
     * @param cellCoordinates the cellCoordinates to set
     */
    public void setCellCoordinates(ArrayList<Point> cellCoordinates) {
        this.cellCoordinates = cellCoordinates;
    }

    /**
     * @return the activeScores
     */
    public int[] getActiveScores() {
        return activeScores;
    }

    /**
     * @param activeScores the activeScores to set
     */
    public void setActiveScores(int[] activeScores) {
        this.activeScores = activeScores;
    }

    /**
     * @param activeScore the number to be tested if it is in
     */
    public boolean isActiveScore(int score) {
        for (int i = 0; i < activeScores.length; i++) {
            if (score == activeScores[i])
                return true;
        }
        return false;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    /**
     * @return the number of cell coordinate locations
     */
    public int size() {
        return this.cellCoordinates.size();
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
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the badItemEaten
     */
    public int getBadItemEaten() {
        return badItemEaten;
    }

    /**
     * @param badItemEaten the badItemEaten to set
     */
    public void setBadItemEaten(int badItemEaten) {
        this.badItemEaten = badItemEaten;
    }

    /**
     * @return the soundResource
     */
    public String getSoundResource() {
        return soundResource;
    }

    /**
     * @param soundResource the soundResource to set
     */
    public void setSoundResource(String soundResource) {
        this.soundResource = soundResource;
    }

    /**
     * @return the growthCounter
     */
    public int getGrowthCounter() {
        return growthCounter;
    }

    /**
     * @param growthCounter the growthCounter to set
     */
    public void setGrowthCounter(int growthCounter) {
        this.growthCounter = growthCounter;
    }
//</editor-fold>

}
