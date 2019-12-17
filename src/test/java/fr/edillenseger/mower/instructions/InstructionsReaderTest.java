package fr.edillenseger.mower.instructions;

import fr.edillenseger.mower.Mower;
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
        Mower mower = instructions.mowers.get(0);
        Assertions.assertNotNull(mower);
        Assertions.assertEquals(1, mower.coordinates.x);
        Assertions.assertEquals(2, mower.coordinates.y);
        Assertions.assertEquals(Orientation.N, mower.orientation);
    }

    @Test
    public void should_read_movements_of_first_mower() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        Mower mower = instructions.mowers.get(0);
        Assertions.assertNotNull(mower);
        Assertions.assertEquals(9, mower.movements.size());
    }

    @Test
    public void should_read_initial_coordinates_of_second_mower() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        Mower mower = instructions.mowers.get(1);
        Assertions.assertNotNull(mower);
        Assertions.assertEquals(3, mower.coordinates.x);
        Assertions.assertEquals(3, mower.coordinates.y);
        Assertions.assertEquals(Orientation.E, mower.orientation);
    }


    @Test
    public void should_read_movements_of_second_mower() {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        Mower mower = instructions.mowers.get(1);
        Assertions.assertNotNull(mower);
        Assertions.assertEquals(10, mower.movements.size());
    }
}