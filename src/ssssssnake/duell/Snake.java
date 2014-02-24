/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import static ssssssnake.duell.Direction.UP;

/**
 *
 * @author user
 */
public class Snake {
    private ArrayList<Point> body;
    private Direction direction = Direction.RIGHT;
    private int growthCounter;
    private Color color;

    {
        body = new ArrayList<>();
    }
    
    public void move(){
        //create a new location for the head using the direction
        int x = 0;
        int y = 0;        
        switch (getDirection()){
            case UP:
                x= 0;
                y= -1;
                break;
                
            case DOWN:
                x= 0;
                y= 1;
                break;
                
            case RIGHT:
                x= 1;
                y= 0;
                break;
            
            case LEFT:
                x= -1;
                y= 0;
            
        }
        
        getBody().add(0, new Point(getHead().x + x, getHead().y + y));
        //delete tail
        
//        System.out.println("GC b = " + getGrowthCounter());
        if (getGrowthCounter() <= 0) {
            getBody().remove(getBody().size() - 1);            
        } else {
            setGrowthCounter(getGrowthCounter() - 1);
        }
//        System.out.println("GC a = " + getGrowthCounter());
     }
    public Point getHead(){
        return getBody().get(0);
    }
    
    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
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

    void grow(int growth) {
        this.growthCounter += growth;
    }

    public boolean checkSelfHit(){
        for (int i = 1; i < body.size(); i++) {
            if (getHead().equals(body.get(i))) {
                return true;
                
            }
        }
                    return false;

    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
}

