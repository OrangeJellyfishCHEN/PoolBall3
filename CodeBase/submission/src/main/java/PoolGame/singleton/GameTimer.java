package PoolGame.singleton;

import PoolGame.observer.Observer;

/**
 * A timer to record time passed during games.
 */
public class GameTimer implements Observer {
    private static GameTimer instance = null;
    private long start;

    private GameTimer(){
        this.start = System.currentTimeMillis();
    }

    /**
     * To get the GameTimer instance
     * @return the GameTimer instance
     */
    public static GameTimer getInstance(){
        if (instance == null){
            instance = new GameTimer();
        }
        return instance;
    }

    /**
     * return an integer array(format:{minute, second})  contains the time passed during the game
     * @return an integer array contains the time passed during the game
     */
    public int[] getTimePass() {
        long current = System.currentTimeMillis() - this.start;
        int secondPass = (int) current / 1000;
        int sec = secondPass % 60;
        int minute = secondPass / 60;
        return new int[]{minute, sec};
    }

    /**
     * reset the timer to run from 0.
     */
    public void reset(){
        this.start = System.currentTimeMillis();
    }

    /**
     * set the timer to the client class expects
     * @param newTime
     */
    public void undo(long newTime){
        long gap = newTime - start;
        this.start = System.currentTimeMillis() - gap;
    }
}
