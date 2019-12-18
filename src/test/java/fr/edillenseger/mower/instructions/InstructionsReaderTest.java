package fr.edillenseger.mower.instructions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstructionsReaderTest {

    @Test
    public void should_read_max_coordinates() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        Assertions.assertEquals(5, instructions.maxCoordinates.x);
        Assertions.assertEquals(5, instructions.maxCoordinates.y);
    }

    @Test
    public void should_read_initial_coordinates_of_first_mower() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        MowerInstructions mowerInstructions = instructions.mowerInstructions.get(0);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(1, mowerInstructions.initialCoordinates.x);
        Assertions.assertEquals(2, mowerInstructions.initialCoordinates.y);
        Assertions.assertEquals(Orientation.N, mowerInstructions.initialOrientation);
    }

    @Test
    public void should_read_movements_of_first_mower() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        MowerInstructions mowerInstructions = instructions.mowerInstructions.get(0);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(9, mowerInstructions.movements.size());
    }

    @Test
    public void should_read_initial_coordinates_of_second_mower() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        MowerInstructions mowerInstructions = instructions.mowerInstructions.get(1);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(3, mowerInstructions.initialCoordinates.x);
        Assertions.assertEquals(3, mowerInstructions.initialCoordinates.y);
        Assertions.assertEquals(Orientation.E, mowerInstructions.initialOrientation);
    }


    @Test
    public void should_read_movements_of_second_mower() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        MowerInstructions mowerInstructions = instructions.mowerInstructions.get(1);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(10, mowerInstructions.movements.size());
    }
}