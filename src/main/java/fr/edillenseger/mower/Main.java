package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Instructions;
import fr.edillenseger.mower.file.FileReader;
import fr.edillenseger.mower.instructions.InstructionsRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String args[]) throws IOException, URISyntaxException {
        FileReader fileReader = new FileReader();
        Instructions instructions = fileReader.readFromResourcesFolder("instructions.txt");
        InstructionsRunner instructionsRunner = new InstructionsRunner();
        instructionsRunner.execute(instructions);
    }
}
