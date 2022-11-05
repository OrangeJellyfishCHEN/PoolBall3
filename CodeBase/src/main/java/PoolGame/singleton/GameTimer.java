package PoolGame.singleton;

import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer {

    @Override
    public void handle(long now) {
        System.out.println(now);
    }
}
