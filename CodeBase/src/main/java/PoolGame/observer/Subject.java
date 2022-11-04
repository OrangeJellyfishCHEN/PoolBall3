package PoolGame.observer;

public interface Subject {
    public void Attach(Observer o);

    public void Detach(Observer o);

    public void Notify(String difficultLevel);
}
