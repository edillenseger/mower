package fr.edillenseger.mower.instructions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InstructionsRunnerTest {

    @Test
    public void should_run_mower_instructions(){
        MowerInstructions mowerInstructions = new MowerInstructions();
        mowerInstructions.initialCoordinates = new Coordinates(1, 1);
        mowerInstructions.initialOrientation = Orientation.N;
        mowerInstructions.movements = Arrays.asList(Movement.F);

        Instructions instructions = new Instructions();
        instructions.maxCoordinates = new Coordinates(5, 5);
        instructions.addMowerInstructions(mowerInstructions);

        InstructionsRunner instructionsRunner = new InstructionsRunner();
        instructionsRunner.execute(instructions);

        Assertions.assertEquals(1, instructionsRunner.getFinalCoordinatesOf(0).x);
        Assertions.assertEquals(2, instructionsRunner.getFinalCoordinatesOf(0).y);
        Assertions.assertEquals(Orientation.N, instructionsRunner.getFinalOrientationOf(0));
    }
}