package fr.edillenseger.mower.instructions;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementY(int incrementY) {
        this.y += incrementY;
    }

    public void incrementX(int incrementX) {
        this.x += incrementX;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
