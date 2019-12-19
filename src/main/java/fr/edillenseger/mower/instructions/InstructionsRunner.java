package fr.edillenseger.mower.instructions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InstructionsRunner {

    private static Logger LOGGER = Logger.getLogger(InstructionsRunner.class.getName());

    public void execute(InstructionsFile instructionsFile) {
        LOGGER.info("Executing instructions");
        instructionsFile.getMowerInstructions().forEach(mowerInstructions -> execute(mowerInstructions, instructionsFile.getMaxCoordinates()));
    }

    private void execute(MowerInstructions mowerInstructions, Coordinates maxCoordinates){
        Mower mower = new Mower(mowerInstructions.initialCoordinates, mowerInstructions.initialOrientation);
        LOGGER.log(Level.INFO, "Executing mower instructions on mower : " + mower.toString());
        mowerInstructions.movements.forEach(movement -> mower.move(movement, maxCoordinates));
        LOGGER.log(Level.INFO, "Mower instructions are successfully executed on mower : " + mower.toString());
    }

}
