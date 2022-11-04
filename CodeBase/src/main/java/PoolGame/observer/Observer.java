package PoolGame.observer;

public interface Observer {
    public void update(String difficultLevel);

    public String getSubjectHardLevel();

    public void setSubjectHardLevel(String difficultLevel);
}
