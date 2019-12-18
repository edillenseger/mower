package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Coordinates;
import fr.edillenseger.mower.instructions.Movement;
import fr.edillenseger.mower.instructions.Orientation;

import java.io.Serializable;

public class Mower implements Serializable {
    public Coordinates coordinates;
    public Orientation orientation;

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

    public void forward(Coordinates maxCoordinates) {
        if(canForward(maxCoordinates)){
            coordinates.x = coordinates.x + orientation.getIncrementX();
            coordinates.y = coordinates.y + orientation.getIncrementY();
        }
    }

    private boolean canForward(Coordinates maxCoordinates){
        int newCoordinatesX = coordinates.x + orientation.getIncrementX();
        int newCoordinatesY = coordinates.y + orientation.getIncrementY();
        return newCoordinatesX >= 0 && newCoordinatesX <= maxCoordinates.x
            && newCoordinatesY >= 0 && newCoordinatesY <= maxCoordinates.y;
    }

    public void move(Movement movement, Coordinates maxCoordinates) {
        if(Movement.F.equals(movement)){
            forward(maxCoordinates);
        } else if(Movement.L.equals(movement)){
            turnLeft();
        } else if(Movement.R.equals(movement)){
            turnRight();
        }
    }

    @Override
    public String toString() {
        return "Position at [" + coordinates.x + "," + coordinates.y + "] / Orientation to " + orientation.getLabel();
    }
}
