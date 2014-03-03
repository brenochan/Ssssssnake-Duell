/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ssssssnake.duell;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author user
 */
public class CountDownTimer {

    /**
     * @return the state
     */
    private State getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    private void setState(State state) {
        this.state = state;
    }

    public static enum State {
        RUNNING, PAUSED
    }
    public static int DEFAULT_SECONDS = 10;

    public void reset() {
        secondsRemaining = DEFAULT_SECONDS;
    }
    
   public void start(){
      setState(State.RUNNING);
   }
   
   public void stop(){
      setState(State.PAUSED);
   }
 
    private void countDown() {
        if (getState() == State.RUNNING) {
            if (System.currentTimeMillis() - lastDecrementTime > 1000 ) {
                secondsRemaining--;
                lastDecrementTime = System.currentTimeMillis();
            }
            
        }
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Propeties">
    private int secondsRemaining;
    private Timer timer;
    private TimerTask timerTask;
    private long lastDecrementTime;
    private State state;

    /**
     * @return the secondsRemaining
     */
    public int getSecondsRemaining() {
        return secondsRemaining;
    }

    /**
     * @param secondsRemaining the secondsRemaining to set
     */
    public void setSecondsRemaining(int secondsRemaining) {
        this.secondsRemaining = secondsRemaining;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="TimerTask">

    private class CountDownTimerTask extends TimerTask {

        @Override
        public void run() {
            countDown();
        }
    }
    //</editor-fold>

    {
        this.timerTask = new CountDownTimerTask();
        this.timer = new Timer();
        this.timer.schedule(timerTask, 100, 500);
        
        this.setState(State.PAUSED);
    }
}
