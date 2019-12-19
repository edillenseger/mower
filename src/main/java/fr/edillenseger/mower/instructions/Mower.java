package fr.edillenseger.mower.instructions;

import java.io.Serializable;
import java.util.List;

public class Mower implements Serializable {
    private Coordinates coordinates;
    private Orientation orientation;

    public Mower(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public void turnLeft() {
        orientation = orientation.getLeft();
    }

    public void turnRight() {
        orientation = orientation.getRight();
    }

    public void moveForward(Coordinates maxCoordinates) {
        if(isWithinBoundaries(maxCoordinates)){
            coordinates.incrementX(orientation.getIncrementX());
            coordinates.incrementY(orientation.getIncrementY());
        }
    }

    private boolean isWithinBoundaries(Coordinates maxCoordinates){
        int newCoordinatesX = coordinates.getX() + orientation.getIncrementX();
        int newCoordinatesY = coordinates.getY() + orientation.getIncrementY();
        boolean withinX = newCoordinatesX >= 0 && newCoordinatesX <= maxCoordinates.getX();
        boolean withinY = newCoordinatesY >= 0 && newCoordinatesY <= maxCoordinates.getY();
        return withinX && withinY;
    }

    public void move(Movement movement, Coordinates maxCoordinates) {
        if(Movement.F.equals(movement)){
            moveForward(maxCoordinates);
        } else if(Movement.L.equals(movement)){
            turnLeft();
        } else if(Movement.R.equals(movement)){
            turnRight();
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Position at [" + coordinates.getX() + "," + coordinates.getY() + "] / Orientation to " + orientation.getLabel();
    }
}
