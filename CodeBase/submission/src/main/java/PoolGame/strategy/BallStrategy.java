package PoolGame.strategy;

/**
 * Ball Strategy for red ball, orange ball, yellow ball
 */
public class BallStrategy extends PocketStrategy {
    /**
     * Creates a new ball strategy.
     */
    public BallStrategy() {
        this.lives = 1;
    }

    /**reset their lives to the initial value**/
    public void reset() {
        this.lives = 1;
    }
}
