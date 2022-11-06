package PoolGame.memento;

import PoolGame.observer.Observer;

public class Caretaker implements Observer{
    // to store the list of history
    private SnapShot snapShot = null;

    // when call this function remember to test null
    public SnapShot recover(){
        return this.snapShot;
    }

    public void saveSnapShot(SnapShot newSnapShot){
        this.snapShot = newSnapShot;
    }

    public void reset(){
        snapShot = null;
    }
}
