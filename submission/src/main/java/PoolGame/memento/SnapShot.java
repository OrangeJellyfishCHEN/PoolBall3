package PoolGame.memento;

import PoolGame.objects.Ball;

import java.util.ArrayList;

/**Store the internal state of the GameManager object.**/
public class SnapShot {
    private ArrayList<Ball> currentBalls;
    private long timeOfSnap;
    private int score;

    public SnapShot(ArrayList<Ball> ballCur, long timeOfSnap, int score){
        this.currentBalls = ballCur;
        this.timeOfSnap = timeOfSnap;
        this.score = score;
    }

    /**
     * return the balls state store in this Snapshot
     * @return the balls state store in this Snapshot
     */
    public ArrayList<Ball> getCurrentBalls() {
        return currentBalls;
    }

    /**
     * return the score state store in this Snapshot
     * @return the score state store in this Snapshot
     */
    public int getScore() {
        return score;
    }

    /**
     * return the time state store in this Snapshot
     * @return the time state store in this Snapshot
     */
    public long getTimeOfSnap() {
        return timeOfSnap;
    }
}
