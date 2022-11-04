package PoolGame.strategy;

public class BlackBallStrategy extends PocketStrategy {
    /** Creates a new blue strategy. */
    public BlackBallStrategy() {
        this.lives = 3;
    }

    public void reset() {
        this.lives = 3;
    }
}
