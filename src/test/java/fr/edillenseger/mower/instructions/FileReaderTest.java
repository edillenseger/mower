package fr.edillenseger.mower.instructions;

import fr.edillenseger.mower.exceptions.*;
import fr.edillenseger.mower.file.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class FileReaderTest {

    @Test
    public void should_read_max_coordinates() throws IOException, URISyntaxException, MowerArgumentException {
        FileReader fileReader = new FileReader();
        InstructionsFile instructions = fileReader.readFromResourcesFolder("instructions.txt");
        Assertions.assertEquals(5, instructions.getMaxCoordinates().getX());
        Assertions.assertEquals(5, instructions.getMaxCoordinates().getY());
    }

    @Test
    public void should_read_initial_coordinates_of_first_mower() throws IOException, URISyntaxException, MowerArgumentException {
        FileReader fileReader = new FileReader();
        InstructionsFile instructions = fileReader.readFromResourcesFolder("instructions.txt");
        MowerInstructions mowerInstructions = instructions.getMowerInstructions().get(0);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(1, mowerInstructions.initialCoordinates.getX());
        Assertions.assertEquals(2, mowerInstructions.initialCoordinates.getY());
        Assertions.assertEquals(Orientation.N, mowerInstructions.initialOrientation);
    }

    @Test
    public void should_read_movements_of_first_mower() throws IOException, URISyntaxException, MowerArgumentException {
        FileReader fileReader = new FileReader();
        InstructionsFile instructions = fileReader.readFromResourcesFolder("instructions.txt");
        MowerInstructions mowerInstructions = instructions.getMowerInstructions().get(0);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(9, mowerInstructions.movements.size());
    }

    @Test
    public void should_read_initial_coordinates_of_second_mower() throws IOException, URISyntaxException, MowerArgumentException {
        FileReader fileReader = new FileReader();
        InstructionsFile instructions = fileReader.readFromResourcesFolder("instructions.txt");
        MowerInstructions mowerInstructions = instructions.getMowerInstructions().get(1);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(3, mowerInstructions.initialCoordinates.getX());
        Assertions.assertEquals(3, mowerInstructions.initialCoordinates.getY());
        Assertions.assertEquals(Orientation.E, mowerInstructions.initialOrientation);
    }

    @Test
    public void should_read_movements_of_second_mower() throws IOException, URISyntaxException, MowerArgumentException {
        FileReader fileReader = new FileReader();
        InstructionsFile instructions = fileReader.readFromResourcesFolder("instructions.txt");
        MowerInstructions mowerInstructions = instructions.getMowerInstructions().get(1);
        Assertions.assertNotNull(mowerInstructions);
        Assertions.assertEquals(10, mowerInstructions.movements.size());
    }
}