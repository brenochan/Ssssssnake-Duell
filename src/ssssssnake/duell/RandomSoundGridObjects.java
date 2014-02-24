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
public class RandomSoundGridObjects extends GridObjects {
    public RandomSoundGridObjects(ArrayList<Point> cellCoordinates, int[] activeScores, int score, int badItemEaten, Image image, String soundResource, int growthCounter) {
        super(cellCoordinates, activeScores, score, badItemEaten, image, soundResource, growthCounter);
    }
    
    /**
     * @return the soundResource
     */
    @Override
    public String getSoundResource() {
        int number = GridObjects.getRandomInteger(1, 4);
        
        switch (number){
            case 1: return "/resources/Upsidedown.wav";
            case 2: return "/resources/Wonderwall.wav";
            case 3: return "/resources/alllights.wav";
            case 4: return "/resources/brightside.wav";
            case 5: return "/resources/apple.wav";
            case 6: return "/resources/apple.wav";
            case 7: return "/resources/apple.wav";
            case 8: return "/resources/apple.wav";
            case 9: return "/resources/apple.wav";
            case 10: return "/resources/apple.wav";
            case 11: return "/resources/apple.wav";
            default: return getSoundResource();
        }
    }
    
}
