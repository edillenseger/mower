package fr.edillenseger.mower.instructions;

import java.io.Serializable;

public class Coordinates implements Serializable {
    public int x;
    public int y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
