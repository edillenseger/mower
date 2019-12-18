package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Coordinates;
import fr.edillenseger.mower.instructions.Orientation;

import java.io.Serializable;

public class Mower implements Serializable {
    public Coordinates coordinates;
    public Orientation orientation;

    public void turnLeft() {
        orientation = orientation.getLeft();
    }

    public void turnRight() {
        orientation = orientation.getRight();
    }
}
