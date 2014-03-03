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
        int number = GridObjects.getRandomInteger(1, 44);
        
        switch (number){
            case 1: return "/resources/Upsidedown.wav";
            case 2: return "/resources/Wonderwall.wav";
            case 3: return "/resources/Writtenstars.wav";
            case 4: return "/resources/adrienne.wav";
            case 5: return "/resources/airplanes.wav";
            case 6: return "/resources/alejandro.wav";
            case 7: return "/resources/alllights.wav";
            case 8: return "/resources/americano.wav";
            case 9: return "/resources/axel.wav";
            case 10: return "/resources/baby.wav";
            case 11: return "/resources/brightside.wav";
            case 12: return "/resources/citylife.wav";
            case 13: return "/resources/closingtime.wav";
            case 14: return "/resources/dance.wav";
            case 15: return "/resources/downroad.wav";
            case 16: return "/resources/eel.wav";
            case 17: return "/resources/empirestate.wav";
            case 18: return "/resources/finechina.wav";
            case 19: return "/resources/friday.wav";
            case 20: return "/resources/gaspedal.wav";
            case 21: return "/resources/iloveit.wav";
            case 22: return "/resources/iloveyouso.wav";
            case 23: return "/resources/jones.wav";
            case 24: return "/resources/lepo.wav";
            case 25: return "/resources/lifegoes.wav";
            case 26: return "/resources/lights.wav";
            case 27: return "/resources/lockedheaven.wav";
            case 28: return "/resources/losingreligion.wav";
            case 29: return "/resources/magic.wav";
            case 30: return "/resources/monster.wav";
            case 31: return "/resources/otherside.wav";
            case 32: return "/resources/parachute.wav";
            case 33: return "/resources/pricetag.wav";
            case 34: return "/resources/pumpedkicks.wav";
            case 35: return "/resources/safesounds.wav";
            case 36: return "/resources/santeria.wav";
            case 37: return "/resources/tenthousand.wav";
            case 38: return "/resources/thinkingabout.wav";
            case 39: return "/resources/titanium.wav";
            case 40: return "/resources/wakeup.wav";
            case 41: return "/resources/wavingflag.wav";
            case 42: return "/resources/whitewalls.wav";
            case 43: return "/resources/wings.wav";
            case 44: return "/resources/wreckingball.wav";
            

                
                
            default: return getSoundResource();
        }
    }
    
}
