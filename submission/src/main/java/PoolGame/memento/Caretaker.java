package PoolGame.memento;

import PoolGame.observer.Observer;

/**Class for Snapshot's Safekeeping**/
public class Caretaker implements Observer{
    // to store the list of history
    private SnapShot snapShot = null;

    /**
     * return the snapshot the caretaker stores.
     * @return the snapshot the caretaker stores.
     */
    // when call this function remember to test null
    public SnapShot recover(){
        return this.snapShot;
    }

    /**
     * update the snapshot the caretaker stores with newSnapShot
     * @param newSnapShot
     */
    public void saveSnapShot(SnapShot newSnapShot){
        this.snapShot = newSnapShot;
    }

    /**
     * Reset the caretaker. Clear the snapshot it stored before.
     */
    public void reset(){
        snapShot = null;
    }
}
