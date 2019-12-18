package fr.edillenseger.mower.instructions;

import java.io.Serializable;
import java.util.List;

public class MowerInstructions implements Serializable {
    public Coordinates initialCoordinates;
    public Orientation initialOrientation;
    public List<Movement> movements;
}
