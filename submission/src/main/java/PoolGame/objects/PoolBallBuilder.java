package PoolGame.objects;

import PoolGame.strategy.BlackBallStrategy;
import PoolGame.strategy.PocketStrategy;
import PoolGame.strategy.BallStrategy;
import PoolGame.strategy.BlueStrategy;

/** Builds pool balls. */
public class PoolBallBuilder implements BallBuilder {
    // Required Parameters
    private String colour;
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;
    private double mass;

    // Variable Parameters
    private boolean isCue = false;
    public PocketStrategy strategy;

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    };

    @Override
    public void setxPos(double xPosition) {
        this.xPosition = xPosition;
    };

    @Override
    public void setyPos(double yPosition) {
        this.yPosition = yPosition;
    };

    @Override
    public void setxVel(double xVelocity) {
        this.xVelocity = xVelocity;
    };

    @Override
    public void setyVel(double yVelocity) {
        this.yVelocity = yVelocity;
    };

    @Override
    public void setMass(double mass) {
        this.mass = mass;
    };

    /**
     * Builds the ball.
     * 
     * @return ball
     */
    public Ball build() {
        if (colour.equals("white")) {
            isCue = true;
            strategy = new BallStrategy();
            //TODO: to change the strategy of balls
        } else if (colour.equals("blue") || colour.equals("green") || colour.equals("purple")) {
            strategy = new BlueStrategy();
        } else if(colour.equals("black") || colour.equals("brown") ){
            strategy = new BlackBallStrategy();
        }
        else {
            strategy = new BallStrategy();
        }

        return new Ball(colour, xPosition, yPosition, xVelocity, yVelocity, mass, isCue, strategy, this.scoreSelect(colour));
    }

    /**
     * calculate the score the ball has the parameter colour should value
     * @param colour
     * @return the score the ball has the parameter colour should value
     */
    private int scoreSelect(String colour){
        if (colour.equals("red")){
            return 1;
        }
        else if (colour.equals("yellow")){
            return 2;
        }
        else if (colour.equals("green")){
            return 3;
        }
        else if (colour.equals("brown")){
            return 4;
        }
        else if (colour.equals("blue")){
            return 5;
        }
        else if (colour.equals("purple")){
            return 6;
        }
        else if (colour.equals("black")){
            return 7;
        }
        else if (colour.equals("orange")){
            return 8;
        }
        else {
            return 0;
        }
        }
    }
