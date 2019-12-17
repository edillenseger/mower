package fr.edillenseger.mower.instructions;

import fr.edillenseger.mower.Mower;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instructions implements Serializable {
    public Coordinates maxCoordinates;
    public List<Mower> mowers;

    public void addMower(Mower mower){
        if(this.mowers == null){
            this.mowers = new ArrayList<>();
        }
        if(mower.coordinates.x <= maxCoordinates.x
            && mower.coordinates.y <= maxCoordinates.y){
            this.mowers.add(mower);
        }
    }
}
