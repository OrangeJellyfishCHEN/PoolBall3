package PoolGame.observer;

/**Interface for attaching, detaching,and notifying observer objects**/
public interface Subject {
    /**
     * Add a new observer to notify
     * @param o
     */
    public void Attach(Observer o);

    /**
     * Remove an observer
     * @param o
     */
    public void Detach(Observer o);

    /**
     * Notify all observers to do update
     */
    public void Notify();
}
