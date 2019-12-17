package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Coordinates;
import fr.edillenseger.mower.instructions.Movement;
import fr.edillenseger.mower.instructions.Orientation;

import java.io.Serializable;
import java.util.List;

public class Mower implements Serializable {
    public Coordinates coordinates;
    public Orientation orientation;
    public List<Movement> movements;//todo ça a sa place ici ?

    public void turnLeft() {
    }
}
