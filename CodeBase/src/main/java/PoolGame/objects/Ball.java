package PoolGame.objects;

import PoolGame.Config;
import PoolGame.observer.Observer;
import PoolGame.strategy.PocketStrategy;
import javafx.scene.paint.Paint;

/** Holds information for all ball-related objects. */
public class Ball implements Observer, Cloneable {

    private Paint colour;
    private double xPosition;
    private double yPosition;
    private double startX;
    private double startY;
    private double xVelocity;
    private double yVelocity;
    private double mass;
    private double radius;
    private boolean isCue;
    private boolean isActive;
    private PocketStrategy strategy;

    private final double MAXVEL = 20;
    private int score;

    public Ball(String colour, double xPosition, double yPosition, double xVelocity, double yVelocity, double mass,
            boolean isCue, PocketStrategy strategy, int score){
        this.colour = Paint.valueOf(colour);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.startX = xPosition;
        this.startY = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.mass = mass;
        this.radius = 10;
        this.isCue = isCue;
        this.isActive = true;
        this.strategy = strategy;
        this.score = score;
    }

    /**
     * Updates ball position per tick.
     */
    public void tick() {
        xPosition += xVelocity;
        yPosition += yVelocity;
    }

    /**
     * Resets ball position, velocity, and activity.
     */

    public void reset() {
        resetPosition();
        isActive = true;
        strategy.reset();
    }

    /**
     * Resets ball position and velocity.
     */
    public void resetPosition() {
        xPosition = startX;
        yPosition = startY;
        xVelocity = 0;
        yVelocity = 0;
    }

    /**
     * Removes ball from play.
     * 
     * @return true if ball is successfully removed
     */
    public boolean remove() {
        if (strategy.remove()) {
            isActive = false;
            return true;
        } else {
            resetPosition();
            return false;
        }
    }

    /**
     * To remove this ball from the table without testing its lives.
     */
    public void cheat(){
        isActive = false;
    }

    /**
     * Sets x-axis velocity of ball.
     * 
     * @param xVelocity of ball.
     */
    public void setxVel(double xVelocity) {
        if (xVelocity > MAXVEL) {
            this.xVelocity = MAXVEL;
        } else if (xVelocity < -MAXVEL) {
            this.xVelocity = -MAXVEL;
        } else {
            this.xVelocity = xVelocity;
        }
    }

    /**
     * Sets y-axis velocity of ball.
     * 
     * @param yVelocity of ball.
     */
    public void setyVel(double yVelocity) {
        if (yVelocity > MAXVEL) {
            this.yVelocity = MAXVEL;
        } else if (yVelocity < -MAXVEL) {
            this.yVelocity = -MAXVEL;
        } else {
            this.yVelocity = yVelocity;
        }
    }

    /**
     * Sets x-axis position of ball.
     * 
     * @param xPosition of ball.
     */
    public void setxPos(double xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Sets y-axis position of ball.
     * 
     * @param yPosition of ball.
     */
    public void setyPos(double yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Getter method for radius of ball.
     * 
     * @return radius length.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Getter method for x-position of ball.
     * 
     * @return x position.
     */
    public double getxPos() {
        return xPosition + Config.getTableBuffer();
    }

    /**
     * Getter method for y-position of ball.
     * 
     * @return y position.
     */
    public double getyPos() {
        return yPosition + Config.getTableBuffer();
    }

    /**
     * Getter method for starting x-position of ball.
     * 
     * @return starting x position.
     */
    public double getStartXPos() {
        return startX;
    }

    /**
     * Getter method for starting y-position of ball.
     * 
     * @return starting y position.
     */
    public double getStartYPos() {
        return startY;
    }

    /**
     * Getter method for starting mass of ball.
     * 
     * @return mass.
     */
    public double getMass() {
        return mass;
    }

    /**
     * Getter method for colour of ball.
     * 
     * @return colour.
     */
    public Paint getColour() {
        return colour;
    }

    /**
     * Getter method for x-axis velocity of ball.
     * 
     * @return x velocity.
     */
    public double getxVel() {
        return xVelocity;
    }

    /**
     * Getter method for y-axis velocity of ball.
     * 
     * @return y velocity.
     */
    public double getyVel() {
        return yVelocity;
    }

    /**
     * Getter method for whether ball is cue ball.
     * 
     * @return true if ball is cue ball.
     */
    public boolean isCue() {
        return isCue;
    }

    /**
     * Getter method for whether ball is active.
     * 
     * @return true if ball is active.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Getter method for how much score this ball worth.
     * @return score of the ball
     */
    public int getScore() {
        return score;
    }

    /**
     * Clone the current instance.
     * @return the deep copy instance of the current instance.
     */
    @Override
    public Ball clone(){
        try {
            return (Ball) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * Getter method for what strategy this ball has.
     * @return strategy this ball has
     */
    public PocketStrategy getStrategy() {
        return strategy;
    }

    /**
     * Setter method for the strategy this ball has.
     */
    public void setStrategy(PocketStrategy strategy) {
        this.strategy = strategy;
    }
}
