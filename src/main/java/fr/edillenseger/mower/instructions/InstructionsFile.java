package fr.edillenseger.mower.instructions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InstructionsFile implements Serializable {
    private Coordinates maxCoordinates;
    private List<MowerInstructions> mowerInstructions = new ArrayList<>();

    public void addMowerInstructions(MowerInstructions mowerInstructions){
        if(isValidMowerInstructions(mowerInstructions)){
            this.mowerInstructions.add(mowerInstructions);
        }
    }

    private boolean isValidMowerInstructions(MowerInstructions mowerInstructions){
        boolean xCoordinateIsCorrect =  mowerInstructions.initialCoordinates.getX() >= 0 && mowerInstructions.initialCoordinates.getX() <= maxCoordinates.getX();
        boolean yCoordinateIsCorrect = mowerInstructions.initialCoordinates.getY() >= 0 && mowerInstructions.initialCoordinates.getY() <= maxCoordinates.getY();
        return xCoordinateIsCorrect && yCoordinateIsCorrect;
    }

    public void addAllMowerInstructions(List<MowerInstructions> allMowerInstructions) {
        allMowerInstructions.forEach(value -> addMowerInstructions(value));
    }

    public Coordinates getMaxCoordinates() {
        return maxCoordinates;
    }

    public void setMaxCoordinates(Coordinates maxCoordinates) {
        this.maxCoordinates = maxCoordinates;
    }

    public List<MowerInstructions> getMowerInstructions() {
        return mowerInstructions;
    }
}
