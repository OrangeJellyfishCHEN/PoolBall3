package PoolGame.strategy;

/**
 * Ball Strategy for blue ball, green ball, purple ball
 */
public class BlueStrategy extends PocketStrategy {
    /** Creates a new blue strategy. */
    public BlueStrategy() {
        this.lives = 2;
    }

    /**reset their lives to the initial value**/
    public void reset() {
        this.lives = 2;
    }
}
