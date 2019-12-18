package fr.edillenseger.mower.instructions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstructionsRunner {

    private static Logger LOGGER = Logger.getLogger(InstructionsRunner.class.getName());

    private List<Mower> mowers;

    public void execute(Instructions instructions) {
        LOGGER.info("Executing instructions");
        if(instructions != null){
            mowers = new ArrayList<>();
            instructions.mowerInstructions.forEach(mowerInstructions -> execute(mowerInstructions, instructions.maxCoordinates));
        } else {
            LOGGER.warning("No instructions to execute");
        }
    }

    private void execute(MowerInstructions mowerInstructions, Coordinates maxCoordinates){
        Mower mower = new Mower(mowerInstructions.initialCoordinates, mowerInstructions.initialOrientation);
        LOGGER.log(Level.INFO, "Executing mower instructions on mower : " + mower.toString());
        mowerInstructions.movements.forEach(movement -> mower.move(movement, maxCoordinates));
        mowers.add(mower);
        LOGGER.log(Level.INFO, "Mower instructions are successfully executed on mower : " + mower.toString());
    }

    public Coordinates getFinalCoordinatesOf(int index) {
        if(mowers != null && index < mowers.size()){
            return mowers.get(index).coordinates;
        }
        return null;
    }

    public Orientation getFinalOrientationOf(int index) {
        if(mowers != null && index < mowers.size()){
            return mowers.get(index).orientation;
        }
        return null;
    }
}
