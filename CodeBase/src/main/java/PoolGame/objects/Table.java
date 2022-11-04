package PoolGame.objects;

import PoolGame.observer.Observer;
import javafx.scene.paint.Paint;
import java.util.List;
import java.util.ArrayList;

/** Holds properties of the table object. */
public class Table{

    private Paint colour;
    private Long xLength;
    private Long yLength;
    private Double friction;
    private List<Pocket> pockets = new ArrayList<Pocket>();
    private String hardLevel;

    public Table(String colour, Long xLength, Long yLength, Double friction) {
        this.colour = Paint.valueOf(colour);
        this.xLength = xLength;
        this.yLength = yLength;
        this.friction = friction;
    }

    /**
     * Gets the colour of the table.
     * 
     * @return colour
     */
    public Paint getColour() {
        return colour;
    }

    /**
     * Gets the x length of the table.
     * 
     * @return xLength
     */
    public Long getxLength() {
        return xLength;
    }

    /**
     * Gets the y length of the table.
     * 
     * @return yLength
     */
    public Long getyLength() {
        return yLength;
    }

    /**
     * Gets the friction of the table.
     * 
     * @return friction
     */
    public Double getFriction() {
        return friction;
    }

    /**
     * Gets the pockets of the table.
     * 
     * @return pockets
     */
    public List<Pocket> getPockets() {
        return pockets;
    }

    public void addPocket(Pocket newPocket){
        this.pockets.add(newPocket);
    }

    /**
     * Initialises the pockets of the table.
     */
    /*private void initialisePockets() {
        pockets.add(new Pocket(10, 10));
        pockets.add(new Pocket(xLength - 10, 10));
        pockets.add(new Pocket(xLength / 2, 10));
        pockets.add(new Pocket(10, yLength - 10));
        pockets.add(new Pocket(xLength - 10, yLength - 10));
        pockets.add(new Pocket(xLength / 2, yLength - 10));
    }*/

    public void clearAll(){
        this.pockets = new ArrayList<>();
    }
}
