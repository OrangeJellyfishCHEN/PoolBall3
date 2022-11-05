package PoolGame.memento;

import PoolGame.objects.Ball;

import java.util.ArrayList;

// Memento Class
public class SnapShot {
    private ArrayList<Ball> currentBalls;
    private long timeOfSnap;
    private int score;

    public SnapShot(ArrayList<Ball> ballCur, long timeOfSnap, int score){
        this.currentBalls = ballCur;
        this.timeOfSnap = timeOfSnap;
        this.score = score;
    }

    public ArrayList<Ball> getCurrentBalls() {
        return currentBalls;
    }

    public int getScore() {
        return score;
    }

    public long getTimeOfSnap() {
        return timeOfSnap;
    }
}
