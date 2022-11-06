package PoolGame.observer;

/**Interface for objects that should be notified of changes in GameManager**/
public interface Observer {

    /**
     * a function to reset itself after get notification.
     */
    public void reset();
}
