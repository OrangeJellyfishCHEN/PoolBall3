package PoolGame.memento;

import PoolGame.observer.Observer;

import java.util.Stack;

public class Caretaker implements Observer{
    // to store the list of history
    private SnapShot snapShot = null;

    // when call this function remember to test null
    public SnapShot getTheLatestSnapShot(){
        return this.snapShot;
    }

    public void saveSnapShot(SnapShot newSnapShot){
        this.snapShot = newSnapShot;
    }

    public void reset(){
        snapShot = null;
    }
}
