package PoolGame.strategy;

/**
 * Ball Strategy for black ball, brown ball
 */
public class BlackBallStrategy extends PocketStrategy {
    /** Creates a new blue strategy. */
    public BlackBallStrategy() {
        this.lives = 3;
    }

    /**reset their lives to the initial value**/
    public void reset() {
        this.lives = 3;
    }
}
