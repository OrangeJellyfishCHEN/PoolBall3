package PoolGame.singleton;

import PoolGame.observer.Observer;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class GameTimer implements Observer {
    private static GameTimer instance = null;
    private long start;

    private GameTimer(){
        this.start = System.currentTimeMillis();
    }
    public static GameTimer getInstance(){
        if (instance == null){
            instance = new GameTimer();
        }
        return instance;
    }

    public int[] getTimePass() {
        /*int minute = secondPass / 60;
        int second = secondPass % 60;
        int[] time = new int[]{minute, second};
        return time;*/
        long current = System.currentTimeMillis() - this.start;
        int secondPass = (int) current / 1000;
        int sec = secondPass % 60;
        int minute = secondPass / 60;
        return new int[]{minute, sec};
    }

    public void reset(){
        this.start = System.currentTimeMillis();
    }
}
