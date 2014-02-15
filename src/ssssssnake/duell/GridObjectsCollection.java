/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class GridObjectsCollection {

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public GridObjectsCollection(){
        collection = new ArrayList<>();
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<GridObjects> collection;
    
    /**
     * @return the active object in the collection
     */
    public ArrayList<GridObjects> getActiveCollection(int score) {
        ArrayList<GridObjects> activeGridObjects = new ArrayList<>();
        
        for (GridObjects gridObjects : collection){
            if (gridObjects.isActiveScore(score)){
                activeGridObjects.add(gridObjects);
            }
        }
        return activeGridObjects;
    }
    
     /**
     * @param collection the collection to set
     */
    public void addToCollection(GridObjects gridObjects) {
        this.collection.add(gridObjects);
    }

    
    /**
     * @return the collection
     */
    public ArrayList<GridObjects> getCollection() {
        return collection;
    }
    
    /**
     * @param collection the collection to set
     */
    public void setCollection(ArrayList<GridObjects> collection) {
        this.collection = collection;
    }
    //</editor-fold>
    
}
