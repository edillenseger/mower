package fr.edillenseger.mower.instructions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instructions implements Serializable {
    public Coordinates maxCoordinates;
    public List<MowerInstructions> mowerInstructions;

    public void addMowerInstructions(MowerInstructions mowerInstructions){
        if(this.mowerInstructions == null){
            this.mowerInstructions = new ArrayList<>();
        }
        if(mowerInstructions != null && canAddMowerInstructions(mowerInstructions)){
            this.mowerInstructions.add(mowerInstructions);
        }
    }

    private boolean canAddMowerInstructions(MowerInstructions mowerInstructions){
        return mowerInstructions.initialCoordinates.x >= 0 && mowerInstructions.initialCoordinates.x <= maxCoordinates.x
                && mowerInstructions.initialCoordinates.y >= 0 && mowerInstructions.initialCoordinates.y <= maxCoordinates.y;
    }
}
